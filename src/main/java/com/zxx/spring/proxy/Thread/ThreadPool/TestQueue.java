package com.zxx.spring.proxy.Thread.ThreadPool;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zxx
 * @date 2020/12/30 14:33
 * @description 1.0
 */
public class TestQueue {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");
        queue.add("e");
        Object[] array = queue.stream().toArray();
        for (String s : queue) {
            System.out.println(queue.element());
        }
        queue.poll();
        for (String s : queue) {

        }



    }
}
