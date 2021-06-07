package org.openmrs.module.nigeriaemr;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.listener.SimpleMessageListenerContainer;

import javax.jms.Queue;
import javax.jms.Session;

@Configuration
public class ActiveMQConfig {
	
	public static final String NDR_QUEUE_NAME = "ndrExportQueue";
	
	@Bean
	public Queue ndrJMSQueue() {
		return new ActiveMQQueue(NDR_QUEUE_NAME);
	}
}
