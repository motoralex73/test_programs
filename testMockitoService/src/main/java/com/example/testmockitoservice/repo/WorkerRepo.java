package com.example.testmockitoservice.repo;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorkerRepo {
    public List<Worker> workerList = List.of(new Worker("Name1", 35, 23400),
                                             new Worker("Name2", 36, 53400),
                                             new Worker("Name3", 39, 73400)
            );
}
