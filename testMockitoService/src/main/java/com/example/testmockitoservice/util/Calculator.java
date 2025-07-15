package com.example.testmockitoservice.util;

import java.util.concurrent.ExecutionException;

public class Calculator {
    public int sum(int a, int b) {
        return a + b;
    }

    public boolean evenOrNot(int a) {
        if (a % 2 == 0) return true;
        else return false;
    }
    
    public int devide(int a, int b) {
        return a/b;
    }
}
