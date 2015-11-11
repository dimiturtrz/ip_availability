package main;

public class User {
	private Boolean loggedIn;
	private int timesLogged;
	private String name;
	
	User(String username){
		loggedIn = false;
		timesLogged = 0;
		name = username;
	}
	
	public Boolean isLogged(){
		return loggedIn;
	}
	
	public int getTimesLogged(){
		return timesLogged;
	}
	
	public String getName(){
		return name;
	}
	
	public void logIn(){
		loggedIn = true;
		timesLogged++;
	}
	public void logOut(){
		loggedIn = false;
	}
}
