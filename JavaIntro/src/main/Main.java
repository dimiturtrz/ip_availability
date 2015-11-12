package main;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

import CommandHandler.*;

public class Main {
	private static ApplicationData appData = new ApplicationData();
	private static Map<String, CommandHandler> commands = new HashMap<String, CommandHandler>();
	public static void main(String[] args){
		addCommands();
		System.out.println("Enter a command");
		final Scanner in = new Scanner(System.in);
		while(!ApplicationData.shutdownIssued()){
			final String command = in.next();
			final String result = execute(command);
			System.out.println(result);
		}
		in.close();
	}
	
	private static String execute(String command){
		String [] split = command.split(":");
		if(commands.get(split[1])!=null)
			return commands.get(split[1]).execute(split, appData);
		else return "error:unknowncommand";
	}
	
	public static void addCommands(){
		commands.put("login", new LoginCommandHandler());
		commands.put("logout", new LogoutCommandHandler());
		commands.put("info", new InfoCommandHandler());
		commands.put("shutdown", new ShutdownCommandHandler());
		commands.put("listavailable", new ListavailableCommandHandler());
	}
}
