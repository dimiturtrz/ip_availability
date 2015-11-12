package socketServer;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import main.ApplicationData;
import CommandHandler.*;

public class ClientHandler implements Runnable{
	private static ApplicationData appData = new ApplicationData();
	private static final Map<String, CommandHandler> commands;
	static{
		commands = new HashMap<String, CommandHandler>();
		commands.put("login", new LoginCommandHandler());
		commands.put("logout", new LogoutCommandHandler());
		commands.put("info", new InfoCommandHandler());
		commands.put("shutdown", new ShutdownCommandHandler());
		commands.put("listavailable", new ListavailableCommandHandler());
	}
	
	private Socket clientSocket;
	private final PrintStream out;
	private final Scanner in;
	
	public ClientHandler(Socket client) throws IOException {
		clientSocket = client;
		out = new PrintStream(clientSocket.getOutputStream());
		in = new Scanner(clientSocket.getInputStream());
	}
	
	public void run(){
		while(!ApplicationData.shutdownIssued()){
			final String command = in.next();
			final String result = execute(command);
			out.println(result);
		}
	}
	
	private synchronized String execute(String command){
		String [] split = command.split(":");
		if(split.length>1 && commands.get(split[1])!=null)
			return commands.get(split[1]).execute(split, appData);
		else return "error:unknowncommand";
	}
	
	public void clean(){
		try {
			out.close();
			in.close();
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
