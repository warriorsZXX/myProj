package com.zxx.spring.proxy.Thread.ThreadPool;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author zxx
 * @date 2020/12/23 17:24
 * @description 1.0
 */
public class DeadLockDemo {
    static String A = "Aassdfasdfasdfadfadf";
    private static String B = "B";

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    private void deadLock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        System.out.println(".");
                        Thread.sleep(0);
                        //print(A);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B) {
                        System.out.println("1");
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("二");
                synchronized (B) {
                    System.out.println("一");
                    synchronized (A) {
                        System.out.println("2");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }

    public void print(String o){
        System.out.println(hashCode());
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
