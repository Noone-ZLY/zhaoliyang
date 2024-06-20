package com.zly.PriorityQueue;

import java.util.PriorityQueue;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/9/25 12:57
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> (b-a));
        priorityQueue.add(8);
        priorityQueue.add(4);
        priorityQueue.add(9);
        System.out.println(priorityQueue.peek());
    }
}
