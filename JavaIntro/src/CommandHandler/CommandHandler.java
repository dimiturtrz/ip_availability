package CommandHandler;

import main.ApplicationData;

public interface CommandHandler {
	public String execute(String[] args, ApplicationData appData);
}
