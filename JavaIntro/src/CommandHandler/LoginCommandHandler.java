package CommandHandler;

import java.util.Map;

import main.User;

public class LoginCommandHandler implements CommandHandler {
	@Override
	public String execute(String[] args, Map<String, User> users){
		if (users.get(args[0]) != null){
			users.get(args[0]).loggedIn = true;
			users.get(args[0]).timesLogged++;
			return "ok"; 
		}else
			return "false username";
	}
}
