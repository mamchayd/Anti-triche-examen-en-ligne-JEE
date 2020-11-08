package est.pfe.webSocket;
import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import est.pfe.metier.Tricheur;
import est.pfe.metier.TricheurMBean;

@ServerEndpoint("/websocket")
public class SessionWebSocket {

  @OnMessage
  public void onMessage(String message, Session session) 
    throws IOException, InterruptedException {
  
    // Print the client message for testing purposes
    System.out.println("Received: " + message);
    	TricheurMBean t=new Tricheur();
    	String msg=String.valueOf(t.isSessionExamDemarer());
      session.getBasicRemote().
        sendText(msg);
  }
  
  @OnOpen
  public void onOpen() {
    System.out.println("Client connected");
  }

  @OnClose
  public void onClose() {
    System.out.println("Connection closed");
  }
}