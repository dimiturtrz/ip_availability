package main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ApplicationData {
	private Set<User> users = new HashSet<User>();
	private static boolean shutdown;

	public ApplicationData(){
		this(new String[0]);
	}
	
	public ApplicationData(String[] starting_users){
		for(String username : starting_users)
			users.add(new User(username));
		shutdown = false;
	}
	
	public void addUser(String name){
		users.add(new User(name));
	}
	
	public User getUser(String name){
		for(Iterator<User> it = users.iterator(); it.hasNext(); ){
			User curr_user = it.next();
			if(name.equals(curr_user.getName()))
				return curr_user;
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
	}
}
