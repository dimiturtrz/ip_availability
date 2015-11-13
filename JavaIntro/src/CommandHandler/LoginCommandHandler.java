package CommandHandler;

import main.ClientApplicationData;
import main.User;

public class LoginCommandHandler implements CommandHandler<ClientApplicationData> {
	@Override
	public synchronized String execute(String[] args, ClientApplicationData appData, User user){
		user = appData.getUser(args[1]);
		if (user != null && user.getSocket() != null){
			user.logOut();
		}else{
			appData.addUser(args[1]);
			user = appData.getUser(args[1]);
		}
		appData.connectUserToClient(user);
		user.logIn();
		return "ok"; 
	}
}
