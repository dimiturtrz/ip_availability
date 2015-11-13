package socketServer;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

import main.ApplicationData;
import main.ClientApplicationData;
import main.User;
import CommandHandler.CommandHandler;
import CommandHandler.InfoCommandHandler;
import CommandHandler.ListabsentCommandHandler;
import CommandHandler.ListavailableCommandHandler;
import CommandHandler.LoginCommandHandler;
import CommandHandler.LogoutCommandHandler;
import CommandHandler.ShutdownCommandHandler;

@SuppressWarnings({"rawtypes", "unchecked"})
public class ClientHandler implements Runnable{
	private ClientApplicationData clientData;
	private static final Map<String, CommandHandler> commands;
	static{
		commands = new HashMap<String, CommandHandler>();
		commands.put("login", new LoginCommandHandler());
		commands.put("logout", new LogoutCommandHandler());
		commands.put("info", new InfoCommandHandler());
		commands.put("shutdown", new ShutdownCommandHandler());
		commands.put("listavailable", new ListavailableCommandHandler());
		commands.put("listabsent", new ListabsentCommandHandler());
	}
	
	private Socket clientSocket;
	private final PrintStream out;
	private final Scanner in;
	private User user = null;
	
	public ClientHandler(Socket client) throws IOException {
		clientSocket = client;
		out = new PrintStream(clientSocket.getOutputStream());
		in = new Scanner(clientSocket.getInputStream());
		clientData = new ClientApplicationData(this);
	}
	
	public void run(){
		try{
			while(!ApplicationData.shutdownIssued()){
				final String command = in.next();
				final String result = execute(command);
				out.println(result);
			}
		} catch(NoSuchElementException nsee){
			clean();
		}
	}
	
	private String execute(String command){
		String [] split = command.split(":");
		if(split.length>1 && commands.get(split[1])!=null)
			return commands.get(split[1]).execute(split, clientData);
		else return "error:unknowncommand";
	}
	
	public Socket getSocket(){
		return clientSocket;
	}
	
	public void setUser(User user){
		if(this.user != null)
			this.user.logOut();
		this.user = user;
	}
	
	public void clean(){
		try {
			out.close();
			in.close();
			if(user != null)
				user.logOut();
			clientSocket.close();
			if(!ApplicationData.shutdownIssued())
				IOServer.clientHandlers.remove(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
