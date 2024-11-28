package com.ps.producer_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ps.producer_service.dto.Student;
import com.ps.producer_service.service.MessageService;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MessageController {
 @Autowired
    private MessageService messageService;

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message) {
        messageService.sendMessage(message);
        return "Message sent: " + message;
    }

    @PostMapping("/sendStudentInfo")
    public String postMethodName(@RequestBody Student student) {
        try {
            messageService.sendMessage(new ObjectMapper().writeValueAsString(student));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "Message Sent: "+student.toString();
    }
    

    @PostMapping("/sendMsgToTopic")
    public String sendMessageToTopic(@RequestBody Student student) {
        messageService.sendMessageToTopic(student);
        return "Message sent: " + student;
    }
    
}
