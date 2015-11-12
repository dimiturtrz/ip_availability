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
	public String to_s(){
		String to_s = "";
		to_s += dateFormat.format(from);
		to_s += dateFormat.format(to);
		return to_s;
	}
}
