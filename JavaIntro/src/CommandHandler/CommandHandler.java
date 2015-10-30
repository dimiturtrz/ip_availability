package CommandHandler;

import java.util.Map;
import main.User;

public interface CommandHandler {
	public String execute(String[] args, Map<String, User> users);
}
