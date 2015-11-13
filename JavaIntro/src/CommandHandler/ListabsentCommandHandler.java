package CommandHandler;

import main.ApplicationData;
import main.User;

public class ListabsentCommandHandler implements CommandHandler<ApplicationData>{
	@Override
	public String execute(String[] args, ApplicationData appData, User user){
		if (user != null){
			String output = "ok";
			for (User checkedUser : appData.getUsers()){
				if(!checkedUser.isLogged())
				    output+=(":"+checkedUser.getName());
			}
			return output;
		}
		return "error:notlogged";
	}
}
