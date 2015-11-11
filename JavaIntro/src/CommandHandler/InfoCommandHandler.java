package CommandHandler;

import main.ApplicationData;

public class InfoCommandHandler implements CommandHandler{
	@Override
	public String execute(String[] args, ApplicationData appData){
		if (appData.getUser(args[0]) != null){
			return ("ok:"+args[0]+":"+appData.getUser(args[2]).isLogged()+":"+appData.getUser(args[2]).getTimesLogged());
		}else
			return "false username";
	}
}
