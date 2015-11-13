package CommandHandler;

import main.ApplicationData;

public interface CommandHandler<App extends ApplicationData> {
	public String execute(String[] args, App handler);
}
