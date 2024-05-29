package com.hiegobarreto.credit_analysis.domain.service;

import com.hiegobarreto.credit_analysis.domain.entities.Proposal;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQNotificationService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void notify(String exchange, Proposal proposal){
        rabbitTemplate.convertAndSend(exchange, "", proposal);
    }
}
