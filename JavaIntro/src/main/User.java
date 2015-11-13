package main;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
	private Boolean loggedIn;
	private int timesLogged;
	private String name;
	private List<Interval> visits = new ArrayList<Interval>();
	private Socket userSocket = null;
	
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
	
	public String getVisits(){
		String string = "";
		for(Interval visit : visits){
			string += visit.toString();
		}
		return string;
	}
	
	public void logIn(){
		if(!isLogged())
			visits.add(new Interval(new Date()));
		loggedIn = true;
		timesLogged++;
	}
	
	public void logOut(){
		loggedIn = false;
		visits.get(visits.size()-1).setLogoutDate(new Date());
		userSocket = null;
	}
	
	public Socket getSocket(){
		return userSocket;
	}
	
	public void setSocket(Socket socket){
		userSocket = socket;
	}
}
