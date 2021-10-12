package com.a20da10.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

@Service
public class ProducerTest {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(String mess){
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                 TextMessage txtMessage = session.createTextMessage("this is the message sent by producer " + mess);
                 return txtMessage;
            }
        });
    }
}
