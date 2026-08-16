import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserDetails(int id) {
        return "Details for: " + userRepository.findUserById(id);
    }
}