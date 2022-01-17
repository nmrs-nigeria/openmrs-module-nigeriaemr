package org.openmrs.module.nigeriaemr.ndrfactory;

import java.io.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.openmrs.api.context.Context;
import org.openmrs.module.nigeriaemr.model.ndr.Container;
import org.openmrs.module.nigeriaemr.omodmodels.GXmlGregorianCalendar;
import org.openmrs.module.nigeriaemr.omodmodels.NDRApiHandshakeSummary;
import org.openmrs.module.nigeriaemr.omodmodels.NDRApiResponse;
import org.openmrs.module.nigeriaemr.omodmodels.NDRAuth;
import org.openmrs.module.nigeriaemr.service.NdrExtractionService;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.datatype.XMLGregorianCalendar;

public class NDRApiUtils {
	
	// Host url
	private String host = "https://localhost:44351/api/Cronbox/";
	
	Integer totalFiles = 0;
	
	Integer pushedFiles = 0;
	
	//	public NDRApiUtils() {
	//		//UniRest client to accept self-signed SSL certificates
	//		setUniRestClient();
	//		//configure UniRest to use Gson Object mapper
	//		configureUnirest();
	//	}
	
	public void setUniRestClient(Unirest unirest) {
		try {
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}
				
				public void checkClientTrusted(X509Certificate[] certs, String authType) {
				}
				
				public void checkServerTrusted(X509Certificate[] certs, String authType) {
				}
				
			} };
			
			SSLContext sslcontext = SSLContext.getInstance("SSL");
			sslcontext.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sslcontext.getSocketFactory());
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext);
			CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
			unirest.setHttpClient(httpclient);
		}
		catch (NoSuchAlgorithmException nex) {
			nex.printStackTrace();
		}
		catch (KeyManagementException kmx) {
			kmx.printStackTrace();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public NDRApiResponse auth(String email, String password) {
		NDRApiResponse apiRes = new NDRApiResponse();
		try {
			Unirest unirest = new Unirest();
			//UniRest client to accept self-signed SSL certificates
			setUniRestClient(unirest);
			// Host url
			String api = host + "auth";
			System.out.println("Authenticating with the NDR...");
			System.out.println("\n");
			//convert to json
			NDRAuth auth = new NDRAuth();
			auth.email = email;
			auth.password = password;
			String json = new Gson().toJson(auth);
			
			//Post request
			HttpResponse<JsonNode> response = unirest.post(api).body(json).asJson();
			//convert response to NDRApiResponse class
			NDRApiResponse apiResponse = new ObjectMapper().readValue(response.getBody().toString(), NDRApiResponse.class);
			if (apiResponse.code > 0 && apiResponse.isAuthenticated) {
				Context.getAdministrationService().setGlobalProperty("ndr_beep", apiResponse.token);
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Calendar c = Calendar.getInstance();
				c.add(Calendar.DATE, 7);
				Context.getAdministrationService().setGlobalProperty("ndr_beep_date", dateFormat.format(c.getTime()));
				System.out.println("\nAuthentication with the NDR was successful\n");
				
			} else {
				//pass error message to view
				System.out.println(apiResponse.message);
				apiResponse.code = -1;
			}
			
			return apiResponse;
		}
		catch (Exception ex) {
			Logger.getLogger(NdrExtractionService.class.getName()).log(Level.SEVERE, null, ex);
			apiRes.code = -1;
			apiRes.message = ex.getMessage();
			return apiRes;
		}
	}
	
	public NDRApiResponse checkAuth() {
		NDRApiResponse apiRes = new NDRApiResponse();
		try {
			String token = Context.getAdministrationService().getGlobalProperty("ndr_beep");
			String tokenDateStr = Context.getAdministrationService().getGlobalProperty("ndr_beep_date");
			
			if (token != null && !token.isEmpty()) {
				apiRes.token = token;
				Date tokenDate = new SimpleDateFormat("yyyy-MM-dd").parse(tokenDateStr);
				Date today = new Date();
				
				if (tokenDate.compareTo(today) > 0) {
					apiRes.code = 5;
					apiRes.isAuthenticated = true;
				} else {
					apiRes.code = -1;
					apiRes.isAuthenticated = false;
					apiRes.message = "Your existing NDR token has expired. Please authenticate your account again.";
				}
			} else {
				apiRes.code = -1;
				apiRes.message = "You don't have an existing authentication token from the NDR";
				apiRes.isAuthenticated = false;
			}
			return apiRes;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			apiRes.code = -1;
			apiRes.message = ex.getMessage();
			return apiRes;
		}
	}
	
	public NDRApiHandshakeSummary pushData(String jsonFolder)
	{
		NDRApiHandshakeSummary summary = new NDRApiHandshakeSummary();
		summary.totalFiles = 0;
		summary.totalPushed = 0;

		//set endpoint
		String api = host + "beep";
		try
		{
			Unirest unirest = new Unirest();
			//configure UniRest to use Gson Object mapper
			configureUnirest(unirest);
			//UniRest client to accept self-signed SSL certificates
			setUniRestClient(unirest);
			
			NDRApiResponse apiRes = checkAuth();
			if (apiRes.code < 1)
			{
				summary.code = -1;
				summary.message = "Your are not authorized to make API calls to the NDR or your Auth token has expired. Please authenticate your account again.";
				return summary;
			}
			List<File> fileList = new ArrayList<File>();
			File folder = new File(jsonFolder);
			//Generate list of the JSON files
			generateJSONFileList(folder, fileList);
			if (fileList == null || fileList.isEmpty())
			{
				summary.code = -1;
				summary.message = "No Patient data to be pushed to the NDR";
				return summary;
			}

			totalFiles = fileList.size();
			summary.totalFiles = totalFiles;
			System.out.println("Total patient (s) to be pushed: " + totalFiles);
			System.out.println("Pushing data to the NDR...");
			List<String> json = new ArrayList<>();

			for (File file : fileList)
			{
				ObjectMapper mapper = new ObjectMapper();
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				mapper.setDateFormat(df);
				Container container = mapper.readValue(new File(file.getPath()), Container.class);
				String data = mapper.writeValueAsString(container);
				json.add(data);
			}

			if (json.isEmpty())
			{
				summary.code = -1;
				summary.message = "No Patient data to be pushed to the NDR";
				return summary;
			}

			List<List<String>> batches = BatchList(json);
			System.out.println("\n Data batches to be pushed: " + batches.size() + "\n");
			if (batches == null || batches.isEmpty())
			{
				summary.code = -1;
				summary.message = "No Patient data to be pushed to the NDR";
				return summary;
			}
			//push the data to the NDR in batches
			for (List<String> batch : batches)
			{
				if (batch != null && !batch.isEmpty())
				{
					HttpResponse<JsonNode> response = unirest.post(api).header("token", apiRes.token).body(batch).asJson();
					String res = response.getBody().toString();
					System.out.println("\n response: " + res + "\n");
					NDRApiResponse apiResponse = new ObjectMapper().readValue(res, NDRApiResponse.class);
					if (apiResponse.code > 0)
					{
						//All went well
						//update feedback to user on the view
						pushedFiles += batch.size();
						summary.totalPushed += batch.size();
						System.out.println("Successfully Pushed " + pushedFiles + " out of " + totalFiles);
					} else {
						System.out.println(apiResponse.message);
					}
				}
			}
			if (summary.totalPushed == summary.totalFiles)
			{
				summary.code = 5;
			}
			if (summary.totalPushed > 0 && summary.totalPushed < summary.totalFiles)
			{
				summary.code = 5;
			}
			if (summary.totalPushed == 0 )
			{
				summary.code = -1;
			}
			return summary;
		}
		catch (Exception ex) {
			Logger.getLogger(NdrExtractionService.class.getName()).log(Level.SEVERE, null, ex);
			summary.code = -1;
			String msg = ex.getMessage();
			if(msg == null || msg.isEmpty())
				msg = "An unknown error was encountered. Please try again or contact the admin for Technical Assistance";
			summary.message = msg;
			return summary;
		}
	}
	
	public void generateJSONFileList(File node, List<File> fileList) {
		// add json files only
		if (node.isFile() && node.getName().endsWith("json")) {
			fileList.add(node);
		} else if (node.isDirectory()) {
			String[] subNote = node.list();
			for (String filename : subNote) {
				generateJSONFileList(new File(node, filename), fileList);
			}
		}
	}
	
	public List<List<String>> BatchList(List<String> files) {
		List<List<String>> batches = Lists.partition(files, 50);
		return batches;
	}
	
	private void configureUnirest(Unirest unirest) {
		unirest.setObjectMapper(new com.mashape.unirest.http.ObjectMapper() {
			
			private Gson gson = new GsonBuilder().disableHtmlEscaping().create();
			
			@Override
			public <T> T readValue(String value, Class<T> valueType) {
				return gson.fromJson(value, valueType);
			}
			
			@Override
			public String writeValue(Object value) {
				return gson.toJson(value);
			}
		});
	}
	
}
