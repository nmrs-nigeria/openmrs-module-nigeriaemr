package org.openmrs.module.nigeriaemr;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

@Configuration
public class ActiveMQConfig {
	
	public static final String NDR_QUEUE_NAME = "ndrExportQueue";
	
	@Bean
	public Queue ndrJMSQueue() {
		return new ActiveMQQueue(NDR_QUEUE_NAME);
	}
}
