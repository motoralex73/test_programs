package ibs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DigitsHappy {
    static int sq(int n) {
        return n*n;
    }
    public static void main(String[] args) {
        var list = List.of(1,2,3,4,5);
        //1
        var list2 = list.parallelStream().map(x -> x*x).toList();
        System.out.println(list2);
        //2
        ExecutorService executorService = Executors.newFixedThreadPool(list.size());
        List<Future<Integer>> futures = list.stream().map(x -> executorService.submit(() -> sq(x))).toList();
        System.out.println(futures);







    }
}
