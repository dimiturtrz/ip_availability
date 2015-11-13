package CommandHandler;

import main.ApplicationData;
import main.User;

public class ShutdownCommandHandler implements CommandHandler<ApplicationData>{
	@Override
	public String execute(String[] args, ApplicationData appData, User user){
		ApplicationData.issueShutdown();
		return "";
	}
}
