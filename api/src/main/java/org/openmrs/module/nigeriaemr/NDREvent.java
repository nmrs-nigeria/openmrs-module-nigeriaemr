package org.openmrs.module.nigeriaemr;

import org.openmrs.module.nigeriaemr.model.NDRExport;
import org.springframework.jms.core.JmsTemplate;

public class NDREvent {
	
	JmsTemplate jmsTemplate;
	
	public NDREvent(final JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public void send(final NDRExport ndrExport) {
		jmsTemplate.convertAndSend(ndrExport);
	}
}
