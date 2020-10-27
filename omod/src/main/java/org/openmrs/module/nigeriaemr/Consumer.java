package org.openmrs.module.nigeriaemr;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.openmrs.api.context.Context;
import org.openmrs.api.context.UserContext;
import org.openmrs.module.nigeriaemr.model.NDRExport;
import org.openmrs.module.nigeriaemr.ndrfactory.NDRExtractor;
import org.openmrs.module.nigeriaemr.service.NdrExtractionService;
import org.openmrs.module.nigeriaemr.util.LoggerUtils;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.xml.bind.JAXBContext;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Consumer implements MessageListener {
	
	JAXBContext jaxbContext;
	
	NDRExtractor ndrExtractor;
	
	NdrExtractionService ndrExtractionService;
	
	ActiveMQObjectMessage msg;
	
	NDRExport ndrExport;
	
	public Consumer() {
		try {
			jaxbContext = JAXBContext.newInstance("org.openmrs.module.nigeriaemr.model.ndr");
		}
		catch (Exception e) {
			LoggerUtils.write(Consumer.class.getName(), e.getMessage(), LoggerUtils.LogFormat.FATAL,
			    LoggerUtils.LogLevel.live);
		}
		ndrExtractor = new NDRExtractor();
		ndrExtractionService = new NdrExtractionService(jaxbContext);
	}
	
	public static void initialize(UserContext userContext) {
		Context.openSession();
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
	}
	
	public void checkIfExportIsComplete() {
		try {
			initialize(null);
			ndrExtractor.checkIfExportIsComplete();
			Context.closeSession();
		}
		catch (Exception e) {
			LoggerUtils.write(Consumer.class.getName(), e.getMessage(), LoggerUtils.LogFormat.FATAL,
			    LoggerUtils.LogLevel.live);
		}
	}
	
	//	@Override
	//	public void onMessage(Message message) {
	//		try {
	//			ActiveMQObjectMessage msg = (ActiveMQObjectMessage) message;
	//			NDRExport ndrExport = (NDRExport) msg.getObject();
	//			Thread thread = new Thread(() -> {
	//				try {
	//					NdrExtractionService ndrExtractionService = new NdrExtractionService(jaxbContext);
	//					initialize(null);
	//					LoggerUtils.write(Consumer.class.getName(),
	//							"processing " + ndrExport.getId() + "with batchID " + ndrExport.getPatientsList(),
	//							LoggerUtils.LogFormat.INFO, LoggerUtils.LogLevel.live);
	//					System.out.println("executing export"+ ndrExport.getId());
	//					message.acknowledge();
	//					ndrExtractionService.export(ndrExport);
	//
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			});
	//			thread.setName("Thread" + ndrExport.getId());
	//			executor.submit(thread);
	//		}
	//		catch (JMSException e) {
	//			e.printStackTrace();
	//		}
	//	}
	
	@Override
	public void onMessage(Message message) {
		try {
			msg = (ActiveMQObjectMessage) message;
			ndrExport = (NDRExport) msg.getObject();
			initialize(null);
			LoggerUtils.write(Consumer.class.getName(),
			    "processing " + ndrExport.getId() + "with batchID " + ndrExport.getPatientsList(),
			    LoggerUtils.LogFormat.INFO, LoggerUtils.LogLevel.live);
			System.out.println("executing export" + ndrExport.getId());
			message.acknowledge();
			ndrExtractionService.export(ndrExport);
		}
		catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public void stopAllExports() {
		try {
			initialize(null);
			ndrExtractionService.pauseFile(null);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
