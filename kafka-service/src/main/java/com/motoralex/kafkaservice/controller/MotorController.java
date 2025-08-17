package com.motoralex.kafkaservice.controller;

import com.motoralex.kafkaservice.service.MotorProducerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MotorController {

    private final MotorProducerService motorProducerService;

    public MotorController(MotorProducerService motorProducerService) {
        this.motorProducerService = motorProducerService;
    }

    @PostMapping("/send")
    public String send(@RequestBody String message) {
        motorProducerService.sendMessage("motor-topic", message);
        return "Success";
    }
}
