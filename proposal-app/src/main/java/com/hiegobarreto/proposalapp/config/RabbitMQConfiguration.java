package com.hiegobarreto.proposalapp.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitMQConfiguration {

    @Value("${rabbitmq.pendingproposal.exchange}")
    private String exchangePendingProposal;
    @Value("${rabbitmq.completedproposal.exchange}")
    private String exchangeCompletedProposal;

    @Bean
    public Queue createQueuePendingProposalMsCreditAnalysis(){
        return QueueBuilder
                .durable("pending-proposal.ms-credit-analysis")
                .build();
    }

    @Bean
    public Queue createQueuePendingProposalMsNotification(){
        return QueueBuilder
                .durable("pending-proposal.ms-notification")
                .build();
    }

    @Bean
    public Queue createQueueCompletedProposalMsProposal(){
        return QueueBuilder
                .durable("completed-proposal.ms-proposal")
                .build();
    }

    @Bean
    public Queue createQueueCompletedProposalMsNotification(){
        return QueueBuilder
                .durable("completed-proposal.ms-notification")
                .build();
    }

    @Bean
    public RabbitAdmin createRabbitAdmin(ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> initializeAdmin(RabbitAdmin rabbitAdmin){
        return event -> rabbitAdmin.initialize();
    }

    @Bean
    public FanoutExchange createFanoutExchangePendingProposal(){
        return ExchangeBuilder.fanoutExchange(exchangePendingProposal).build();
    }

    @Bean
    public FanoutExchange createFanoutExchangeCompletedProposal(){
        return ExchangeBuilder.fanoutExchange(exchangeCompletedProposal).build();
    }

    @Bean
    public Binding createBindingPendingProposalMsCreditAnalysis(){
        return BindingBuilder.bind(createQueuePendingProposalMsCreditAnalysis())
                .to(createFanoutExchangePendingProposal());
    }

    @Bean
    public Binding createBindingPendingProposalMsNotification(){
        return BindingBuilder.bind(createQueuePendingProposalMsNotification())
                .to(createFanoutExchangePendingProposal());
    }

    @Bean
    public Binding createBindingCompletedProposalMsProposalApp(){
        return BindingBuilder.bind(createQueueCompletedProposalMsProposal())
                .to(createFanoutExchangeCompletedProposal());
    }

    @Bean
    public Binding createBindingCompletedProposalMsNotification(){
        return BindingBuilder.bind(createQueueCompletedProposalMsNotification())
                .to(createFanoutExchangeCompletedProposal());
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());

        return rabbitTemplate;
    }
}
