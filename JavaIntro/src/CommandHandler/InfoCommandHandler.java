package CommandHandler;

import main.ApplicationData;
import main.User;

public class InfoCommandHandler implements CommandHandler<ApplicationData>{
	@Override
	public String execute(String[] args, ApplicationData appData, User user){
		if (user != null && appData.getUser(args[1]) != null){
			User user2 = appData.getUser(args[1]);
			return ("ok:"+args[1]+":"+user2.isLogged()+":"+user2.getTimesLogged()+user2.getVisits());
		}
		
		return "error:notlogged";
	}
}
