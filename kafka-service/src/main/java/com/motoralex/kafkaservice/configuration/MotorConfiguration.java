package com.motoralex.kafkaservice.configuration;

import com.motoralex.kafkaservice.controller.MotorController;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MotorConfiguration {
    @Bean
    public NewTopic newTopic() {
        return new NewTopic("motor-topic", 1, (short) 1);
    }
}
