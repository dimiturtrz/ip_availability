package CommandHandler;

import main.ApplicationData;
import main.User;

public class InfoCommandHandler implements CommandHandler<ApplicationData>{
	@Override
	public String execute(String[] args, ApplicationData appData){
		if (appData.getUser(args[0]) != null){
			User user2 = appData.getUser(args[2]);
			return ("ok:"+args[0]+":"+user2.isLogged()+":"+user2.getTimesLogged()+":"+user2.getVisits());
		}else
			return "error:notlogged";
	}
}
