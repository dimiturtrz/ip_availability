package CommandHandler;

import java.util.Map;

import main.User;

public class ShutdownCommandHandler implements CommandHandler{
	@Override
	public String execute(String[] args, Map<String, User> users){
		User.shutdown = true;
		return "";
	}
}
