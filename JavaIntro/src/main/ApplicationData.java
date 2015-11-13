package main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import socketServer.IOServer;

public class ApplicationData {
	private static Set<User> users = new HashSet<User>();
	private static boolean shutdown;

	public ApplicationData(){
		this(new String[0]);
	}
	
	public ApplicationData(String[] startingUsers){
		for(String username : startingUsers)
			users.add(new User(username));
		shutdown = false;
	}
	
	public void addUser(String name){
		users.add(new User(name));
	}
	
	public User getUser(String name){
		for(Iterator<User> it = users.iterator(); it.hasNext(); ){
			User currUser = it.next();
			if(name.equals(currUser.getName()))
				return currUser;
		}
		return null;
	}
	
	public User[] getUsers(){
		return users.toArray(new User[users.size()]);
	}
	
	public static boolean shutdownIssued() {
		return shutdown;
	}

	public static void issueShutdown() {
		ApplicationData.shutdown = true;
		IOServer.stopServer();
	}
}
