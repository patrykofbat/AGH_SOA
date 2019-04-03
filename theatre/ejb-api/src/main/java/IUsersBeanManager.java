import models.User;

import java.util.ArrayList;

public interface IUsersBeanManager {
    ArrayList<User> getUsersList();
    User getUserByToken(String token);
    void setUser(User user);
}
