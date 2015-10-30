package CommandHandler;

import java.util.Map;

import main.User;

public class ListavailableCommandHandler implements CommandHandler{
	@Override
	public String execute(String[] args, Map<String, User> users){
		if (users.get(args[0]) != null){
			String output = "ok";
			for (Map.Entry<String, User> entry : users.entrySet()){
				if(entry.getValue().loggedIn)
				    output+=(":"+entry.getKey());
			}
			return output;
		}
		return "false username";
	}
}
