package chat_app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import chat_app.service.ChatService;
import chat_app.entity.Message;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ChatController {

    @Autowired
    private ChatService service;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        if(service.login(username, password)) {
            return "SUCCESS";
        }
        return "FAIL";
    }

    @PostMapping("/send")
    public Message send(@RequestParam String sender,
                        @RequestParam String receiver,
                        @RequestParam String content) {
        return service.sendMessage(sender, receiver, content);
    }

    @GetMapping("/messages")
    public List<Message> getMessages(@RequestParam String u1,
                                     @RequestParam String u2) {
        return service.getMessages(u1, u2);
    }
}