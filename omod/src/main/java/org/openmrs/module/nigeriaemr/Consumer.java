package org.openmrs.module.nigeriaemr;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.codehaus.jackson.map.ObjectMapper;
import org.openmrs.api.context.Context;
import org.openmrs.api.context.UserContext;
import org.openmrs.module.nigeriaemr.model.NDRExport;
import org.openmrs.module.nigeriaemr.model.ndr.Container;
import org.openmrs.module.nigeriaemr.ndrfactory.NDRApiUtils;
import org.openmrs.module.nigeriaemr.ndrfactory.NDRExtractor;
import org.openmrs.module.nigeriaemr.service.NdrExtractionService;
import org.openmrs.module.nigeriaemr.util.LoggerUtils;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Consumer implements MessageListener {
	
	JAXBContext jaxbContext;
	
	NDRExtractor ndrExtractor;
	
	static String opt;
	
	public Consumer() {
		try {
			jaxbContext = JAXBContext.newInstance("org.openmrs.module.nigeriaemr.model.ndr");
		}
		catch (Exception e) {
			LoggerUtils.write(Consumer.class.getName(), e.getMessage(), LoggerUtils.LogFormat.FATAL,
			    LoggerUtils.LogLevel.live);
		}
	}
	
	public static void initialize(UserContext userContext, String extractionOpt) {
		Context.openSession();
		opt = extractionOpt;
		if (userContext != null) {
			Context.setUserContext(userContext);
		} else {
			Context.setUserContext(Context.getUserContext());
		}
		Context.openSessionWithCurrentUser();
		Context.addProxyPrivilege(NigeriaemrConfig.MODULE_PRIVILEGE);
		Context.addProxyPrivilege(NigeriaemrConfig.MODULE_PRIVILEGE);
		Context.addProxyPrivilege(NigeriaemrConfig.MODULE_PRIVILEGE);
		Context.addProxyPrivilege("Get Patients");
		Context.addProxyPrivilege("Get Observations");
		Context.addProxyPrivilege("Get Encounters");
		Context.addProxyPrivilege("Get Concepts");
		Context.addProxyPrivilege("Get Users");
		Context.addProxyPrivilege("Get Identifier Types");
		Context.addProxyPrivilege("Manage Global Properties");
	}
	
	public void checkIfExportIsComplete() {
		try {
			NdrExtractionService ndrExtractionService = new NdrExtractionService(jaxbContext);
			initialize(null, opt);
			ndrExtractionService.checkIfExportIsComplete();
			Context.clearSession();
			Context.closeSession();
		}
		catch (Exception e) {
			LoggerUtils.write(Consumer.class.getName(), e.getMessage(), LoggerUtils.LogFormat.FATAL,
			    LoggerUtils.LogLevel.live);
		}
	}
	
	@Override
	public void onMessage(Message message) {
		try {
			message.acknowledge();
			NdrExtractionService ndrExtractionService = new NdrExtractionService(jaxbContext);
			ActiveMQObjectMessage msg = (ActiveMQObjectMessage) message;
			NDRExport ndrExport = (NDRExport) msg.getObject();
			initialize(null, opt);
			LoggerUtils.write(Consumer.class.getName(),
			    "processing " + ndrExport.getId() + "with batchID " + ndrExport.getPatientsList(),
			    LoggerUtils.LogFormat.INFO, LoggerUtils.LogLevel.live);
			System.out.println("executing export" + ndrExport.getId());
			ndrExtractionService.export(ndrExport, opt);
			Context.clearSession();
			Context.closeSession();
			
			//System.gc();
		}
		catch (JMSException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void stopAllExports() {
		try {
			NdrExtractionService ndrExtractionService = new NdrExtractionService(jaxbContext);
			initialize(null, opt);
			ndrExtractionService.pauseFile(null);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
