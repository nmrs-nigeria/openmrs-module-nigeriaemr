package org.openmrs.module.nigeriaemr;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import groovy.lang.Singleton;
import org.glassfish.tyrus.server.Server;
import org.openmrs.module.nigeriaemr.omodmodels.Realtime;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Configuration
@ServerEndpoint(value = "/realtime")
public class SocketServer
{
	private Session session;
	private static Set<SocketServer> chatEndpoints = new CopyOnWriteArraySet<>();
	private static HashMap<String, String> users = new HashMap<>();

	public SocketServer() throws DeploymentException
	{
		System.out.println("\nSocket Server Called!!!!\n");
		//new Server("localhost", 8081, "/openmrs", null, SocketServer.class).start();
	}

	@OnOpen
	public void onOpen( Session session, @PathParam("username") String username) throws IOException, EncodeException
	{
		try{
			this.session = session;
			chatEndpoints.add(this);
			users.put(session.getId(), username);
			Realtime message = new Realtime();
			broadcast(message);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	public void refresh() throws IOException, EncodeException
	{
		Realtime message = new Realtime();
		message.code = 5;
		message.message = "Data Extraction completed";
		broadcast(message);
	}

	@OnMessage
	public void onMessage(Session session, Integer code)
			throws IOException, EncodeException
	{
		Realtime realtime = new Realtime();
		realtime.code = code;
		broadcast(realtime);
	}

	@OnClose
	public void onClose(Session session) throws IOException, EncodeException {

		System.out.println("Disconnected!");
		chatEndpoints.remove(this);
		Realtime message = new Realtime();
		message.from = users.get(session.getId());
		message.content = "Disconnected!";
		broadcast(message);
	}

	@OnError
	public void onError(Session session, Throwable throwable)
	{
		System.out.println(throwable.getMessage());
	}

	private static void broadcast(Realtime message) throws IOException, EncodeException
	{
		chatEndpoints.forEach(endpoint ->
		{
			synchronized (endpoint)
			{
				try
				{
					endpoint.session.getBasicRemote().sendObject(message);
				} catch (IOException | EncodeException e)
				{
					e.printStackTrace();
				}
			}
		});
	}
}
