package CommandHandler;

import main.ClientApplicationData;

public class LoginCommandHandler implements CommandHandler<ClientApplicationData> {
	@Override
	public synchronized String execute(String[] args, ClientApplicationData appData){
		if (appData.getUser(args[0]) != null)
			appData.getUser(args[0]).logIn();
		else{
			appData.addUser(args[0]);
			appData.getUser(args[0]).logIn();
		}
		return "ok"; 
	}
}
