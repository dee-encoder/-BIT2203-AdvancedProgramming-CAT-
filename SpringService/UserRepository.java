import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public String findUserById(int id) {
        // Simulated data access logic
        return "User" + id;
    }
}
