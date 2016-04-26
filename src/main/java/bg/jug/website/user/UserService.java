package bg.jug.website.user;

import bg.jug.website.model.user.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * @author Ivan St. Ivanov
 */
@Stateless
public class UserService {

    @Inject
    private UserRepository userRepository;

    public User addUser(User newUser) {
        return userRepository.save(newUser);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
