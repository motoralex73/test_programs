package collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

//Колекция очередь(FIFO) и двухсторонняя очередь (FIFO and LIFO)
public class CollectionQueue {

    public static void main(String[] args) {
        //FIFO
        Queue queue = new PriorityQueue();
        queue.add(new Object().toString());
        //двухсторонняя очередь
        Deque deque = new ArrayDeque();
        deque.add(123);
        deque.add(123);
        deque.add("hello");
        //deque.add(null); //так нельзя делать
        deque.addAll(queue);
        System.out.println(deque);
    }
}
