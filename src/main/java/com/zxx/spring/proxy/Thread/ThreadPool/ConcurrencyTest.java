package com.zxx.spring.proxy.Thread.ThreadPool;

/**
 * @author zxx
 * @date 2020/12/21 15:16
 * @description 1.0
 */
public class ConcurrencyTest {
    private static final long count = 100000000000L;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        concurrency();
        serial();
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(()-> {
              {
                System.out.println(Thread.currentThread().getName());

                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                    //System.out.println("dayingd zhi"+a);
                }
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println("concurrency :" + time + "ms,b=" + b);
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        System.out.println(Thread.currentThread().getName());
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time + "ms,b=" + b + ",a=" + a);
    }
}
