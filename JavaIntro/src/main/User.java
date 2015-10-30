package main;

public class User {
	public Boolean loggedIn;
	public int timesLogged;
	public static Boolean shutdown;
	
	User(){
		loggedIn = false;
		timesLogged = 0;
		shutdown = false;
	}
}
