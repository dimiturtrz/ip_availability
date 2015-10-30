package CommandHandler;

import java.util.Map;

import main.User;

public class InfoCommandHandler implements CommandHandler{
	@Override
	public String execute(String[] args, Map<String, User> users){
		if (users.get(args[0]) != null){
			return ("ok:"+args[0]+":"+users.get(args[2]).loggedIn+":"+users.get(args[2]).timesLogged);
		}else
			return "false username";
	}
}
