package com.example.testmockitoservice.service;

import com.example.testmockitoservice.repo.Worker;
import com.example.testmockitoservice.repo.WorkerRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class WorkerServiceTest {
    @Mock
    private WorkerRepo workerRepo;
    @InjectMocks
    private WorkerService workerService;

    @Test
    void sumSalary() {
        List<Worker> list = List.of(new Worker("Name2", 36, 53400));
        Mockito.when(workerRepo.workerList).thenReturn(list);

        int sum = workerService.getSumAllSalary();
        System.out.println("test salary = " + sum);
        Assertions.assertEquals(150200, sum);
    }
}