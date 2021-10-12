package com.a20da10.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class StatefulMessageListener {
    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    private Integer studentId;
    @JmsListener(destination = "destinationQueue",containerFactory ="jmsLinstenerContainerFactory"  )
    public void getMessage(Message message){
        if (message !=null){
            TextMessage textMessage = (TextMessage) message;
            try {
                String txtMessage = textMessage.getText();
                System.out.println("this is the listner from session for this student" + txtMessage);
            } catch (JMSException e) {
                e.printStackTrace();
            }

        }
    }
}
