package chat_app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import chat_app.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsernameAndPassword(String username, String password);
}