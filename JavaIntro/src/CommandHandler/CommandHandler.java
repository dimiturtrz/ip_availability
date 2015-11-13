package CommandHandler;

import main.ApplicationData;
import main.User;

public interface CommandHandler<App extends ApplicationData> {
	public String execute(String[] args, App handler, User user);
}
