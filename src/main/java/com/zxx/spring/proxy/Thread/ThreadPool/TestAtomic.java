package com.zxx.spring.proxy.Thread.ThreadPool;

import javax.swing.text.StyledEditorKit;

/**
 * @author zxx
 * @date 2020/12/31 11:19
 * @description 1.0
 */
public class TestAtomic {
    private static int  a = 0;
     static int thread_count = 5;

    public static void main(String[] args) {
        Thread[] threads = new Thread[thread_count];
            for(int i = 0; i<5 ;i++){
                threads[i] = new Thread(()->{
                    for (int j = 0; j<10 ; j++){
                        System.out.println(a++);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                threads[i].start();
            }
        }
    }
