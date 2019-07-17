package com.sahan.jms.producer;

import com.sahan.jms.model.Sms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsProducer {
    @Autowired
    private final JmsTemplate jmsTemplate;

    @Value("${activemq.queue}")
    String queue;

    public JmsProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send(Sms sms){
        jmsTemplate.convertAndSend(queue, sms);
    }
}
