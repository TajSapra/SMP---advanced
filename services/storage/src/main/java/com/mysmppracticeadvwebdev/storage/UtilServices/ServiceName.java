package com.mysmppracticeadvwebdev.storage.UtilServices;

import org.springframework.stereotype.Component;

@Component
public class ServiceName implements com.mysmppracticeadvwebdev.messaging.ServiceName {
    @Override
    public String getServiceName() {
        return "storage";
    }
}
