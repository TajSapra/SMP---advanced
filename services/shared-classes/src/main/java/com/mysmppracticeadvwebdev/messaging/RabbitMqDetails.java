package com.mysmppracticeadvwebdev.messaging;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RabbitMqDetails {
    public List<String> queueList = Arrays.asList(
            "delete.users.posts",
            "delete.users.chats",
            "delete.users.storage",
            "delete.users.posts",
            "delete.users.interactions",
            "delete.posts.interactions",
            "delete.posts.storage",
            "delete.chats.storage"
    );

    public String exchangeName = "service.routing";

    public List<String> getQueueList(){
        return queueList;
    }

    public String getExchangeName(){
        return exchangeName;
    }
}
