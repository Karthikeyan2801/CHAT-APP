package chat_app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import chat_app.repository.*;
import chat_app.entity.*;

import java.util.List;

@Service
public class ChatService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private MessageRepository msgRepo;

    public boolean login(String username, String password) {
        User user = userRepo.findByUsernameAndPassword(username, password);
        return user != null;
    }

    public Message sendMessage(String sender, String receiver, String content) {
        Message msg = new Message();
        msg.setSender(sender);
        msg.setReceiver(receiver);
        msg.setContent(content);
        return msgRepo.save(msg);
    }

    public List<Message> getMessages(String u1, String u2) {
        return msgRepo.findBySenderAndReceiverOrSenderAndReceiver(u1, u2, u2, u1);
    }
}