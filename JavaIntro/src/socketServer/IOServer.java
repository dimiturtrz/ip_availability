package socketServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import main.ApplicationData;

public class IOServer {
	static ServerSocket listener;
	public static List<ClientHandler> clientHandlers = Collections.synchronizedList(new ArrayList<ClientHandler>());
	
	public IOServer(int port) {
		try {
			listener = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("connect to "+port);
	}
	
	public void runServer() {
		while(!ApplicationData.shutdownIssued()){
			ClientHandler client;
			try {
				client = new ClientHandler(listener.accept());
				new Thread(client).start();
				clientHandlers.add(client);
			}
			catch (SocketException se) {
				System.out.println("closing server socket");;
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void stopServer() {
		try {
			Iterator<ClientHandler> clientIterator = clientHandlers.iterator();
			while (clientIterator.hasNext()){
				clientIterator.next().clean();
				clientIterator.remove();
			}
			listener.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
