package CommandHandler;

import main.ApplicationData;

public class LoginCommandHandler implements CommandHandler {
	@Override
	public String execute(String[] args, ApplicationData appData){
		if (appData.getUser(args[0]) != null)
			appData.getUser(args[0]).logIn();
		else{
			appData.addUser(args[0]);
			appData.getUser(args[0]).logIn();
		}
		return "ok"; 
	}
}
