package com.mysmppracticeadvwebdev.messaging;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RabbitMqConfig {

    @Bean
    public DirectExchange serviceExchange(){
        RabbitMqDetails rabbitMqDetails = new RabbitMqDetails();
        return new DirectExchange(rabbitMqDetails.getExchangeName());
    }

    @Bean
    public Jackson2JsonMessageConverter  jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Declarables queuesAndBindings(){
        List<Declarable>declarables = new ArrayList<>();
        RabbitMqDetails rabbitMqDetails = new RabbitMqDetails();

        DirectExchange exchange = new DirectExchange(rabbitMqDetails.getExchangeName());
        declarables.add(exchange);

        List<String> queueList = rabbitMqDetails.getQueueList();
        for (String queueName : queueList) {
            Queue queue = new Queue(queueName, true);
            declarables.add(queue);

            Binding binding = BindingBuilder.bind(queue).to(exchange).with(rabbitMqDetails.getExchangeName()+"."+queueName);
            declarables.add(binding);
        }
        return new Declarables(declarables);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
                                         Jackson2JsonMessageConverter converter) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(converter);
        return template;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(
            ConnectionFactory connectionFactory,
            Jackson2JsonMessageConverter messageConverter) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(messageConverter);
        return factory;
    }
}
