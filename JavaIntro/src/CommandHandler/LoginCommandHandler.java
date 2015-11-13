package CommandHandler;

import main.ClientApplicationData;
import main.User;

public class LoginCommandHandler implements CommandHandler<ClientApplicationData> {
	@Override
	public synchronized String execute(String[] args, ClientApplicationData appData){
		User user = appData.getUser(args[0]);
		if (user != null && user.getSocket() != null){
			user.logOut();
		}else{
			appData.addUser(args[0]);
			user = appData.getUser(args[0]);
		}
		appData.connectUserToClient(user);
		user.logIn();
		return "ok"; 
	}
}
