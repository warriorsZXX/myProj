package com.zxx.spring.proxy.Thread.ThreadPool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author zxx
 * @date 2020/11/25 11:03
 * @description 1.0
 */
public class FixedSizeThreadPool {
    private  int poolSize;

    private int taskSize;

    //多个线程
    public List<Thread> workers;
    //仓库
    public BlockingQueue<Runnable> queue;
    //需要一个开关来控制线程
    public volatile boolean isworking = true;


    //poolSize 工作线程的数量
    //taskSize 任务数量
    public FixedSizeThreadPool(int poolSize,int taskSize){
        if (poolSize<=0 || taskSize <=0){
            throw new IllegalArgumentException("非法参数错误");
        }
        this.queue = new LinkedBlockingQueue<>(taskSize);
        //线程安全的list
        this.workers = Collections.synchronizedList(new ArrayList<>());

        //创建线程，将线程放入list钟
        for (int i = 0;i<poolSize; i++){
            Worker worker = new Worker(this);
            worker.start();
            workers.add(worker);
        }
    }

   public boolean excute(Runnable runnable){
        if (isworking){
            //往阻塞队列中添加任务
            return this.queue.offer(runnable);
        }
        return false;
   }

   public void shutDown(){
        this.isworking = false;
        for (Thread thread : workers){
            if (Thread.State.BLOCKED.equals(thread.getState())){
                thread.interrupt();
            }
        }
   }



    
}

