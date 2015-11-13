package main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Interval {
	Date from;
	Date to;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy­-MM-­dd'T'HH'_'mm'_'ss.SSSZ");
	Interval(Date startDate){
		from = startDate;
		to = null;
	}
	public void setLogoutDate(Date logoutDate){
		to = logoutDate;
	}
	
	@Override
	public String toString(){
		String string = "";
		string += ":" + dateFormat.format(from);
		if(to!=null)
			string += ":" + dateFormat.format(to);
		return string;
	}
}
