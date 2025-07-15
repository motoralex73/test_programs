package com.example.testmockitoservice;

import com.example.testmockitoservice.repo.Worker;
import com.example.testmockitoservice.repo.WorkerRepo;
import com.example.testmockitoservice.util.Calculator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@SpringBootApplication
public class TestMockitoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestMockitoServiceApplication.class, args);
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter a = ");
//        Integer a = scanner.nextInt();
//        Integer b = scanner.nextInt();
//        Calculator c = new Calculator();
//        System.out.println("Sum a + b = " + c.sum(a,b));

    }
}
