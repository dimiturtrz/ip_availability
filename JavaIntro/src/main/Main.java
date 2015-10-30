package main;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

import CommandHandler.*;

public class Main {
	private static Map<String, User> users = new HashMap<String, User>();
	private static Map<String, CommandHandler> commands = new HashMap<String, CommandHandler>();
	public static void main(String[] args){
		addExampleUsers();
		addCommands();
		System.out.println("Enter a command");
		final Scanner in = new Scanner(System.in);
		while(!User.shutdown){
			final String command = in.next();
			final String result = execute(command);
			System.out.println(result);
		}
		in.close();
	}
	
	private static String execute(String command){
		String [] split = command.split(":");
		if(commands.get(split[1])!=null)
			return commands.get(split[1]).execute(split, users);
		else return "error:unknowncommand";
	}
	
	public static void addExampleUsers(){
		users.put("pesho", new User());
		users.put("petar", new User());
		users.put("kiril", new User());
		users.put("pipi", new User());
		users.put("gosho", new User());
		users.put("misho", new User());
	}
	
	public static void addCommands(){
		commands.put("login", new LoginCommandHandler());
		commands.put("logout", new LogoutCommandHandler());
		commands.put("info", new InfoCommandHandler());
		commands.put("shutdown", new ShutdownCommandHandler());
		commands.put("listavailable", new ListavailableCommandHandler());
	}
}
