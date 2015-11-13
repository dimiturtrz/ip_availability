package socketServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

import main.ApplicationData;

public class IOServer {
	static ServerSocket listener;
	public static List<ClientHandler> clientHandlers = new ArrayList<ClientHandler>();
	
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
			try {
				ClientHandler client = new ClientHandler(listener.accept());
				new Thread(client).start();
				clientHandlers.add(client);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void stopServer() {
		try {
			for(ClientHandler client : clientHandlers){
				client.clean();
			}
			listener.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
