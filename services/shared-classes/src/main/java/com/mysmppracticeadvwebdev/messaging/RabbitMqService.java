package com.mysmppracticeadvwebdev.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RabbitMqService {
    private final RabbitTemplate rabbitTemplate;
    private final ServiceName serviceName;

    public RabbitMqService(RabbitTemplate rabbitTemplate, ServiceName serviceName) {
        this.rabbitTemplate = rabbitTemplate;
        this.serviceName = serviceName;
    }

    public void sendMessageToQueue(String routingName, String message, Object data) {
        System.out.println("Sending " + message + " from service: " + serviceName.getServiceName());
        Map<String, Object> payload = new HashMap<>();
        payload.put("source", serviceName.getServiceName());
        payload.put("message", message);
        payload.put("data", data);
        rabbitTemplate.convertAndSend("service.routing", routingName, payload);
        System.out.println("Sent " + message + " from service: " + serviceName.getServiceName());
    }

}
