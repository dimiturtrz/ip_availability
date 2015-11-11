package CommandHandler;

import main.ApplicationData;

public class ShutdownCommandHandler implements CommandHandler{
	@Override
	public String execute(String[] args, ApplicationData appData){
		ApplicationData.issueShutdown();
		return "";
	}
}
