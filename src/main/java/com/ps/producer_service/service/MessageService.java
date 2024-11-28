package com.ps.producer_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.ps.producer_service.dto.Student;

import jakarta.jms.Queue;
@Service
public class MessageService {
    @Autowired
    private Queue queueName;
    @Value("${spring.activemq.topic}")
    private String topic;

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(String message) {
        jmsTemplate.convertAndSend(queueName, message);
    }

    public void sendMessageToTopic(Student message) {
        jmsTemplate.convertAndSend(topic, message);
    }
}
