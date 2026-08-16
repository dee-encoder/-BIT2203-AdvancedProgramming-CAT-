import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public String findUserById(int id) {
        return "User" + id;
    }
}
