package CommandHandler;

import main.ClientApplicationData;
import main.User;

public class LogoutCommandHandler implements CommandHandler<ClientApplicationData>{
	@Override
	public synchronized String execute(String[] args, ClientApplicationData appData, User user){
		if (user != null){
			appData.disconnectUserFromClient();
			user.logOut();
			return "ok";
		}else
			return "error:notlogged";
	}
}
