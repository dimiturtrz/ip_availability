package CommandHandler;

import java.util.Map;

import main.User;

public class LogoutCommandHandler implements CommandHandler{
	@Override
	public String execute(String[] args, Map<String, User> users){
		if (users.get(args[0]) != null){
			users.get(args[0]).loggedIn = false;
			return "ok";
		}else
			return "false username";
	}
}
