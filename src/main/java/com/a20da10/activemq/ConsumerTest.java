package com.a20da10.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ConsumerTest {
    @Autowired
    private JmsTemplate jmsTemplate;
    public void receiveMessage(){
        String receivedMessage = (String) jmsTemplate.receiveAndConvert();
        System.out.println(receivedMessage);
    }
}
