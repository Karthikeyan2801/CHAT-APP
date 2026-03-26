package chat_app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import chat_app.entity.Message;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    List<Message> findBySenderAndReceiverOrSenderAndReceiver(
        String s1, String r1, String s2, String r2
    );
}