package CommandHandler;

import main.ApplicationData;

public class LogoutCommandHandler implements CommandHandler{
	@Override
	public String execute(String[] args, ApplicationData appData){
		if (appData.getUser(args[0]) != null){
			appData.getUser(args[0]).logOut();
			return "ok";
		}else
			return "false username";
	}
}
