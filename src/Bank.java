import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, User> users;

    public Bank() {
        users = new HashMap<>();
        // Adding some sample users for testing
        users.put("user1", new User("user1", "1234", 5000.0));
        users.put("user2", new User("user2", "5678", 3000.0));
    }

    public User validateUser(String userId, String pin) {
        User user = users.get(userId);
        if (user != null && user.getPin().equals(pin)) {
            return user;
        }
        return null;
    }
}
