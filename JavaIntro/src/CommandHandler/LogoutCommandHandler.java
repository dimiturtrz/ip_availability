package CommandHandler;

import main.ClientApplicationData;

public class LogoutCommandHandler implements CommandHandler<ClientApplicationData>{
	@Override
	public synchronized String execute(String[] args, ClientApplicationData appData){
		if (appData.getUser(args[0]) != null){
			appData.disconnectUserFromClient();
			appData.getUser(args[0]).logOut();
			return "ok";
		}else
			return "error:notlogged";
	}
}
