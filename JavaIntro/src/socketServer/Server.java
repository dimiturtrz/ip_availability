package socketServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static final int SERVER_PORT = 4242;
	static ServerSocket listener;
	
	Server(int port) throws IOException{
		listener = new ServerSocket(SERVER_PORT);
	}
	
	static void runServer() throws IOException{
		Socket client = listener.accept();
		clean();
	}
	
	private static void clean() throws IOException{
		listener.close();
	}
}
