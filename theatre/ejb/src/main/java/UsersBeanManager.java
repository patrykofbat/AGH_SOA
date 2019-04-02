import models.User;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.UUID;

@Stateful
@Remote(IRemoteUsersBeanManager.class)
public class UsersBeanManager implements IUsersBeanManager{
    private ArrayList<User> users;

    public UsersBeanManager() {
        this.users = this.loadUsers();
    }


    @Override
    public ArrayList<User> getUsersList() {
        return this.users;
    }

    @Override
    public User getUserByToken(String token) {
        return this.users
                .stream()
                .filter(user -> user.getToken().toString().equals(token))
                .findAny()
                .orElse(null);
    }

    private ArrayList<User> loadUsers() {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User(
                "User" + i,
                20.0 * (i + 1),
                null,
                UUID.randomUUID()
            );
            users.add(user);
        }
        return users;
    }
}
