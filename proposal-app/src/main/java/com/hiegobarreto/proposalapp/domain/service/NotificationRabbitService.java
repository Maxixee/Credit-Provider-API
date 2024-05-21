package com.hiegobarreto.proposalapp.domain.service;

import com.hiegobarreto.proposalapp.domain.entities.Proposal;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NotificationRabbitService {

    private final RabbitTemplate rabbitTemplate;

    public void notify(Proposal proposal,
                       String exchange){

        rabbitTemplate.convertAndSend(exchange, "", proposal);

    }
}
