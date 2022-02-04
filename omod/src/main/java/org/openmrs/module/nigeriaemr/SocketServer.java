package org.openmrs.module.nigeriaemr;

import org.openmrs.module.nigeriaemr.omodmodels.Realtime;
import org.springframework.context.annotation.Configuration;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Configuration
@ServerEndpoint("/realtime")
public class SocketServer
{
	private Session session;
	private static Set<SocketServer> chatEndpoints = new CopyOnWriteArraySet<>();
	private static HashMap<String, String> users = new HashMap<>();
	public SocketServer()
	{
		System.out.println("\nSocketServer Init Called\n");
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
	public void onMessage(Session session, Realtime message)
			throws IOException, EncodeException
	{
		broadcast(message);
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
