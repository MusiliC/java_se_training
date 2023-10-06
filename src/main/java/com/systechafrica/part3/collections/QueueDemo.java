package com.systechafrica.part3.collections;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        workingWithQueue();
    }

    public static void workingWithQueue() {
        Queue<PrintJob> queue = new LinkedList<>();
        queue.add(new PrintJob("Article Writing"));
        queue.add(new PrintJob("Book Writing"));
        queue.add(new PrintJob("Journal Writing"));
        queue.offer(new PrintJob("Article offer Writing"));

        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.peek()); //?Retrieves the first element of the stack
        System.out.println(queue.remove()); //?removes the first element - printed then removed
        System.out.println(queue);
    }
}
