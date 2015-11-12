package socketServer;

import java.io.IOException;
import java.net.ServerSocket;

import main.ApplicationData;

public class IOServer {
	static ServerSocket listener;
	
	public IOServer(int port) {
		try {
			listener = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("connect to "+port);
	}
	
	public void runServer() {
		try{
			while(!ApplicationData.shutdownIssued()){
				ClientHandler client = new ClientHandler(listener.accept());
				client.run();
			}
			clean();
		} catch(IOException ioe){ioe.printStackTrace();}
	}
	
	private static void clean() throws IOException{
		listener.close();
	}
}
