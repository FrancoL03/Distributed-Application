package com.a20da10.activemq;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Service
public class MyMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        if (message !=null){
            TextMessage textMessage = (TextMessage) message;
            try {
                String txtMessage = textMessage.getText();
                System.out.println("receive message from listner "+txtMessage);
            } catch (JMSException e) {
                e.printStackTrace();
            }

        }
    }
}
