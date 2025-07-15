package com.example.testmockitoservice.controller;

import com.example.testmockitoservice.service.WorkerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class WorkerController {
    public final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping("/salary")
    public int getSumSalary() {
        return workerService.getSumAllSalary();
    }
}
