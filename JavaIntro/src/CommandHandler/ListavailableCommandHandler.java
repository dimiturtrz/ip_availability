package CommandHandler;

import main.ApplicationData;
import main.User;

public class ListavailableCommandHandler implements CommandHandler<ApplicationData>{
	@Override
	public String execute(String[] args, ApplicationData appData){
		if (appData.getUser(args[0]) != null){
			String output = "ok";
			for (User user : appData.getUsers()){
				if(user.isLogged())
				    output+=(":"+user.getName());
			}
			return output;
		}
		return "error:notlogged";
	}
}
