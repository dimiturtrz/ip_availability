package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
	private Boolean loggedIn;
	private int timesLogged;
	private String name;
	private List<Interval> visits = new ArrayList<Interval>();
	
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
		String to_s = "";
		for(Interval visit : visits){
			to_s += visit.to_s();
		}
		return to_s;
	}
	
	public void logIn(){
		loggedIn = true;
		timesLogged++;
		if(!isLogged())
			visits.add(new Interval(new Date()));
	}
	
	public void logOut(){
		loggedIn = false;
		visits.get(visits.size()-1).setLogoutDate(new Date());
	}
}
