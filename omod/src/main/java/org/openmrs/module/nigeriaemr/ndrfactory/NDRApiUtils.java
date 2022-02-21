package org.openmrs.module.nigeriaemr.ndrfactory;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.openmrs.api.context.Context;
import org.openmrs.module.nigeriaemr.model.ndr.Container;
import org.openmrs.module.nigeriaemr.omodmodels.NDRApiHandshakeSummary;
import org.openmrs.module.nigeriaemr.omodmodels.NDRApiResponse;
import org.openmrs.module.nigeriaemr.omodmodels.NDRAuth;
import org.openmrs.module.nigeriaemr.service.NdrExtractionService;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import java.util.stream.Collectors;

public class NDRApiUtils {
	
	//beep_gate
	private String host = Context.getAdministrationService().getGlobalProperty("beep_gate");
	
	private String beepSize = Context.getAdministrationService().getGlobalProperty("beep_size");
	
	Integer totalFiles = 0;
	
	Integer pushedFiles = 0;
	
	//	public NDRApiUtils()
	//	{
	//		host = Context.getAdministrationService().getGlobalProperty("ndr_beep_date");
	//	}
	public void setUniRestClient(Unirest unirest) {
		try {
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				
				public X509Certificate[] getAcceptedIssuers() {
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
			String api = StringUtils.removeEnd(host, "/").trim() + "/auth";
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
		String fPath = "";
		try
		{
			//set endpoint
			host = StringUtils.removeEnd(host, "/");
			String api = host.trim() + "/beep";

			Unirest unirest = new Unirest();
			//configure UniRest to use Gson Object mapper
			configureUnirest(unirest);
			//UniRest client to accept self-signed SSL certificates
			setUniRestClient(unirest);
			
			NDRApiResponse apiRes = checkAuth();
			if (apiRes.code < 1)
			{
				summary.code = -1;
				summary.message = "You are not authorized to make API calls to the NDR or your Auth token has expired. Please authenticate your account again.";
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
		catch (Exception ex)
		{
			Logger.getLogger(NdrExtractionService.class.getName()).log(Level.SEVERE, null, ex);
			summary.code = -1;
			String msg = ex.getMessage();
			if(msg == null || msg.isEmpty())
				msg = "An unknown error was encountered. Please try again or contact the admin for Technical Assistance";
			summary.message = msg;
			return summary;
		}
	}
	
	public NDRApiHandshakeSummary pushBatchData(String jsonFolder)
	{
		NDRApiHandshakeSummary summary = new NDRApiHandshakeSummary();
		summary.totalFiles = 0;
		summary.totalPushed = 0;
		try
		{
			//set endpoint
			String api = StringUtils.removeEnd(host, "/").trim() + "/beep";
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

			File folder = new File(jsonFolder);
			//fetch only a given number of files from directory per each AJAX call from the front-end
			Integer batchSize = 50;
			if(beepSize != null && !beepSize.isEmpty())
			{
				try
				{
					batchSize = Integer.parseInt(beepSize);
				}
				catch (NumberFormatException e)
				{
					batchSize = 50;
				}
			}
			List<Path> files = FetchFiles(folder, batchSize);
			//Generate list of the JSON files
			if (files == null || files.isEmpty() || files.size() < 1)
			{
				summary.code = -1;
				summary.message = "No Patient data to be pushed to the NDR";
				return summary;
			}

			List<String> json = new ArrayList<>();
			List<Path> validFiles = new ArrayList<>();
			for (Path path : files)
			{
				ObjectMapper mapper = new ObjectMapper();
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				mapper.setDateFormat(df);
				try
				{
					Container container = mapper.readValue(new File(path.toFile().getPath()), Container.class);
					//Somehow, for some JSON file, fileMapper fail to handle the read string from the files
					if(container == null || container.getMessageHeader() == null || container.getIndividualReport() == null || container.getValidation() == null)
					{
						String t = new String(Files.readAllBytes(path));
						json.add(t);
						validFiles.add(path);
					}
					else if(container != null && container.getMessageHeader() != null && container.getIndividualReport() != null && container.getValidation() != null)
					{
						String data = mapper.writeValueAsString(container);
						json.add(data);
						validFiles.add(path);
					}
//					else
//					{
//						System.out.println("\nMapped Data is empty\n");
//					}
				}
				catch (Exception ex)
				{
					System.out.println("\nERROR:\n");
					System.out.println(path.toFile().getPath() + "\n");
					System.out.println(ex.getMessage());
				}
			}

			if (json.isEmpty() || json.isEmpty())
			{
				summary.code = -1;
				summary.message = "No Patient data to be pushed to the NDR";
				return summary;
			}

			totalFiles = json.size();
			summary.totalFiles = totalFiles;
			System.out.println("\nPatient(s) to be pushed: " + totalFiles);

			System.out.println("\nPushing data to the NDR...");
			//push the data to the NDR in batches
			HttpResponse<JsonNode> response = unirest.post(api).header("token", apiRes.token).body(json).asJson();
			String res = response.getBody().toString();
			System.out.println("\n response: " + res + "\n");
			NDRApiResponse apiResponse = new ObjectMapper().readValue(res, NDRApiResponse.class);
			if (apiResponse.code > 0)
			{
				//All went well
				//update feedback to user on the view
				pushedFiles += json.size();
				summary.totalPushed += json.size();
				System.out.println("Successfully Pushed " + pushedFiles + " out of " + totalFiles);
				//Delete the successfully pushed files
				for (Path path : validFiles)
				{
					Files.delete( path );
				}
				summary.code = 5;
			}
			else
			{
				System.out.println(apiResponse.message);
				summary.code = -1;
			}
			return summary;
		}
		catch (Exception e)
		{
			Logger.getLogger(NdrExtractionService.class.getName()).log(Level.SEVERE, null, e);
			summary.code = -1;
			String msg = e.getMessage();
			if(msg == null || msg.isEmpty())
				msg = "An unknown error was encountered. Please try again or contact the admin for Technical Assistance";
			summary.message = msg;
			return summary;
		}
	}
	
	public void generateJSONFileList(File node, List<File> fileList) {
		// add json files only
		if (node.isFile() && node.getName().endsWith("json") && node.length() > 0) {
			fileList.add(node);
			//Filter out files from the error folder
		} else if (node.isDirectory() && !node.getName().contains("error")) {
			String[] subNote = node.list();
			for (String filename : subNote) {
				generateJSONFileList(new File(node, filename), fileList);
			}
		}
	}
	
	public Integer getTotalFiles(String jsonFolder) {
		Integer totalFiles = 0;
		List<File> fileList = new ArrayList<File>();
		File folder = new File(jsonFolder);
		//Generate list of the JSON files
		generateJSONFileList(folder, fileList);
		if (fileList == null || fileList.isEmpty()) {
			return totalFiles;
		}
		totalFiles = fileList.size();
		return totalFiles;
	}
	
	public List<List<String>> BatchList(List<String> files) {
		List<List<String>> batches = Lists.partition(files, 20);
		return batches;
	}
	
	public List<Path> FetchFiles(File node, Integer pageSize) throws IOException
	{
		Path folder = Paths.get(node.getPath());
		List<Path> collect = Files.walk(folder)
				//Filter out empty files and files from the error folder
				.filter(p ->  Files.isRegularFile(p) && p.toFile().length() > 0 && !p.toString().contains("error") && p.getFileName().toString().contains("json"))
				.limit(pageSize)
				.collect(Collectors.toList());
		return collect;
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
