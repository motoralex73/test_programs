package com.example.testmockitoservice.service;

import com.example.testmockitoservice.repo.Worker;
import com.example.testmockitoservice.repo.WorkerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {

    public final WorkerRepo workerRepo;

    public WorkerService(WorkerRepo workerRepo) {
        this.workerRepo = workerRepo;
    }

    public int getSumAllSalary() {
        int sum = 0;
        for (Worker w : workerRepo.workerList) sum += w.getMoney();
        System.out.println("Salary all workers = " + sum);
        return sum;
    }
}
