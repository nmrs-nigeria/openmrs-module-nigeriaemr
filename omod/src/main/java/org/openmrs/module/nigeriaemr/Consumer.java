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

public class Consumer implements MessageListener {
	
	JAXBContext jaxbContext;
	
	NdrExtractionService ndrExtractionService;
	
	NDRExtractor ndrExtractor;
	
	public Consumer() {
		try {
			jaxbContext = JAXBContext.newInstance("org.openmrs.module.nigeriaemr.model.ndr");
		}
		catch (Exception e) {
			LoggerUtils.write(Consumer.class.getName(), e.getMessage(), LoggerUtils.LogFormat.FATAL,
			    LoggerUtils.LogLevel.live);
		}
		ndrExtractionService = new NdrExtractionService(jaxbContext);
		ndrExtractor = new NDRExtractor();
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
	
	@Override
	public void onMessage(Message message) {
		try {
			initialize(null);
			ActiveMQObjectMessage msg = (ActiveMQObjectMessage) message;
			NDRExport ndrExport = (NDRExport) msg.getObject();
			LoggerUtils.write(Consumer.class.getName(),
			    "processing " + ndrExport.getId() + "with batchID " + ndrExport.getPatientsList(),
			    LoggerUtils.LogFormat.INFO, LoggerUtils.LogLevel.live);
			ndrExtractionService.export(ndrExport);
		}
		catch (JMSException e) {
			e.printStackTrace();
		}
		try {
			message.acknowledge();
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
