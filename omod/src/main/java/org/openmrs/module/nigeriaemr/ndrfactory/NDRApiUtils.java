package org.openmrs.module.nigeriaemr.ndrfactory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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
import org.openmrs.api.APIException;
import org.openmrs.api.context.Context;
import org.openmrs.module.nigeriaemr.api.dao.NigeriaemrDao;
import org.openmrs.module.nigeriaemr.api.service.NigeriaemrService;
import org.openmrs.module.nigeriaemr.model.ApiLog;
import org.openmrs.module.nigeriaemr.model.NDRExportBatch;
import org.openmrs.module.nigeriaemr.model.ndr.Container;
import org.openmrs.module.nigeriaemr.model.MessageLog;
import org.openmrs.module.nigeriaemr.model.ndrMessageLog;
import org.openmrs.module.nigeriaemr.omodmodels.NDRApiHandshakeSummary;
import org.openmrs.module.nigeriaemr.omodmodels.NDRApiResponse;
import org.openmrs.module.nigeriaemr.omodmodels.NDRAuth;
import org.openmrs.module.nigeriaemr.service.NdrExtractionService;
import org.openmrs.module.nigeriaemr.util.LoggerUtils;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.Console;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class NDRApiUtils {
	
	//beep_gate
	private String host = Context.getAdministrationService().getGlobalProperty("beep_gate");
	
	private String beepSize = Context.getAdministrationService().getGlobalProperty("beep_size");
	
	private String beepUser = Context.getAdministrationService().getGlobalProperty("beep_user");
	
	private String beepPass = Context.getAdministrationService().getGlobalProperty("beep_pass");
	
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
		NDRAuth auth = new NDRAuth();
		try {
			boolean b = (email != null && !email.isEmpty()) && (password != null && !password.isEmpty());
			if (b) {
				auth.email = email;
				auth.password = password;
			} else {
				if ((beepUser != null && !beepUser.isEmpty()) && (beepPass != null && !beepPass.isEmpty())) {
					auth.email = beepUser;
					auth.password = beepPass;
				} else {
					apiRes.code = -1;
					apiRes.message = "Log in credentials are either empty or incorrect";
					return apiRes;
				}
			}
			
			Unirest unirest = new Unirest();
			//UniRest client to accept self-signed SSL certificates
			setUniRestClient(unirest);
			// Host url
			String api = StringUtils.removeEnd(host, "/").trim() + "/auth";
			System.out.println("Authenticating with the NDR...");
			System.out.println("\n");
			
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
				
				if (((beepUser == null || beepUser.isEmpty()) && (beepPass == null || beepPass.isEmpty())) && b) {
					Context.getAdministrationService().setGlobalProperty("beep_user", email);
					Context.getAdministrationService().setGlobalProperty("beep_pass", password);
				}
				
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
			
			if ((beepUser != null && !beepPass.isEmpty()) && (beepPass != null && !beepPass.isEmpty())) {
				apiRes.credentialsProvided = true;
			} else {
				apiRes.credentialsProvided = false;
			}
			
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
			List<String> emptyFiles = new ArrayList<>();
			File folder = new File(jsonFolder);
			//Generate list of the JSON files
			generateJSONFileList(folder, fileList, emptyFiles);
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
				mapper.setDefaultPropertyInclusion(JsonInclude.Value.construct(JsonInclude.Include.NON_NULL,
						JsonInclude.Include.ALWAYS));
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				mapper.setDateFormat(df);
				try
				{
					Container container = mapper.readValue(new File(path.toFile().getPath()), Container.class);

					//Somehow, for some JSON file, fileMapper fail to handle the read string from the files
					if(container == null || container.getMessageHeader() == null || container.getIndividualReport() == null || container.getValidation() == null)
					{
						String t = new String(Files.readAllBytes(path));
						System.out.println("From Read as String\n");
						System.out.println(t);
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
					System.out.println("\nERROR EXCEPTION:\n");
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
				summary.batchNumber = apiResponse.batchNumber;
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

			System.out.println("\nException in DATA PUSH" );
			System.out.println(msg);

			return summary;
		}
	}
	
	public Integer getErrorLogs() {
		Integer logsPulled = 0;
		try {
			NigeriaemrService nigeriaemrService = Context.getService(NigeriaemrService.class);
			//set endpoint
			String api = StringUtils.removeEnd(host, "/").trim() + "/errorLogs";
			Unirest unirest = new Unirest();
			//configure UniRest to use Gson Object mapper
			configureUnirest(unirest);
			//UniRest client to accept self-signed SSL certificates
			setUniRestClient(unirest);
			
			NDRApiResponse apiRes = checkAuth();
			System.out.println("\napiRes.code: " + apiRes.code);
			if (apiRes.code < 1) {
				System.out
				        .println("\n\"Your are not authorized to make API calls to the NDR or your Auth token has expired. Please authenticate your account again.");
				return 0;
			}
			
			List<NDRExportBatch> ndrExportBatches = nigeriaemrService.getBatchExports();
			if (ndrExportBatches == null || ndrExportBatches.size() < 1)
				return 0;
			
			for (NDRExportBatch ndrExportBatch : ndrExportBatches) {
				String batchIds = ndrExportBatch.getNdrBatchIds();
				
				if (batchIds.isEmpty())
					continue;
				
				List<String> batchSrs = Arrays.asList(batchIds.split(","));
				
				if (batchSrs.isEmpty())
					continue;
				
				for (String batch : batchSrs) {
					System.out.println("\nreading Error logs for " + batch);
					String apiQur = api + "?batchId=" + batch;
					HttpResponse<JsonNode> response = unirest.get(apiQur).header("token", apiRes.token).asJson();
					String res = response.getBody().toString();
					ApiLog apiLog = new ObjectMapper().readValue(res, ApiLog.class);
					if (apiLog == null)
						continue;
					if (apiLog.code < 1) {
						System.out.println(apiLog.message);
						continue;
					}
					List<MessageLog> logs = apiLog.messageLogs;
					if (logs.size() > 0) {
						logsPulled += logs.size();
						for (MessageLog log : logs) {
							//Add to database
							ndrMessageLog messageLog = new ndrMessageLog();
							messageLog.setExportId(ndrExportBatch.getId());
							messageLog.setMessage(log.message);
							messageLog.setPatientIdentifier(log.patientIdentifier);
							messageLog.setFileName(log.fileName);
							messageLog.setDateCreated(log.dateCreated);
							messageLog.setBatchNumber(batch);
							nigeriaemrService.saveNdrApiErrorLog(messageLog);
						}
					} else {
						System.out.println("\nNo Error logs available for " + batch);
					}
				}
				nigeriaemrService.updateBatchExport(ndrExportBatch.getId(), "yes");
			}
			
			return logsPulled;
		}
		catch (Exception e) {
			Logger.getLogger(NdrExtractionService.class.getName()).log(Level.SEVERE, null, e);
			String msg = e.getMessage();
			if (msg == null || msg.isEmpty())
				msg = "\nAn unknown error was encountered. Please try again or contact the admin for Technical Assistance";
			System.out.println(msg);
			return logsPulled;
		}
	}
	
	public void saveNDRBatchIds(String batchIds, Integer exportId) {
		try {
			NigeriaemrService nigeriaemrService = Context.getService(NigeriaemrService.class);
			nigeriaemrService.setBatchIdsFromNdr(exportId, batchIds);
			return;
		}
		catch (Exception e) {
			Logger.getLogger(NdrExtractionService.class.getName()).log(Level.SEVERE, null, e);
			String msg = e.getMessage();
			if (msg == null || msg.isEmpty())
				msg = "\nAn unknown error was encountered. Please try again or contact the admin for Technical Assistance";
			System.out.println(msg);
			return;
		}
	}
	
	public void generateJSONFileList(File node, List<File> fileList, List<String> emptyFiles) {
		// add json files only
		if (node.isFile()) {
			String fileN = node.getName();
			if (fileN.endsWith("json")) {
				if (node.length() > 0) {
					fileList.add(node);
				} else {
					emptyFiles.add(fileN);
				}
			}
		} else if (node.isDirectory() && !node.getName().contains("error")) {
			String[] subNote = node.list();
			for (String filename : subNote) {
				generateJSONFileList(new File(node, filename), fileList, emptyFiles);
			}
		}
	}
	
	public String getZippedFile(String folder) {
		File f = new File(folder);
		FilenameFilter f2 = new FilenameFilter() {
			
			public boolean accept(File dir, String filename) {
				String fn = filename.toLowerCase(Locale.ROOT);
				return (fn.endsWith("zip") && !fn.contains("error"));
			}
		};
		if (f.list(f2).length > 0) {
			return f.list(f2)[0];
		}
		
		return "";
	}
	
	public String getTotalFiles(String jsonFolder, String contextPath)
	{
		try {
			NigeriaemrService nigeriaemrService = Context.getService(NigeriaemrService.class);
			Integer totalFiles = 0;
			Integer batchExportId = 0;
			List<File> fileList = new ArrayList<File>();
			List<String> emptyFiles = new ArrayList<>();
			File folder = new File(jsonFolder);
			//Generate list of the JSON files
			generateJSONFileList(folder, fileList, emptyFiles);
			if (fileList == null || fileList.isEmpty()) {
				return totalFiles.toString();
			}
			String zipFileName = getZippedFile(jsonFolder);
			if (zipFileName.length() > 0)
			{
				String cntxtPth = contextPath.replace("/", "");
				String path = Paths.get(cntxtPth, "downloads", "NDR", zipFileName).toString();
				path = "\\" + path;
				NDRExportBatch batchExport = nigeriaemrService.getNDRExportByZipFileName(path);
				if (batchExport != null)
				{
					batchExportId = batchExport.getId();
				}
			}
			totalFiles = fileList.size();
			String errorFiles = "";
			if(emptyFiles.size() > 0)
				errorFiles = String.join(",", emptyFiles);

			String res = batchExportId.toString() + ";" + totalFiles + ";" + errorFiles;
			return res;
		}
		catch (APIException e) {
			LoggerUtils.write(NigeriaemrDao.class.getName(), e.getMessage(), LoggerUtils.LogFormat.INFO,
			    LoggerUtils.LogLevel.live);
			return "";
		}
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
