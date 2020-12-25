package com.zxx.spring.proxy.Thread.ThreadPool;

/**
 * @author zxx
 * @date 2020/11/26 11:22
 * @description 具体线程
 */
public class Worker extends java.lang.Thread {
    private FixedSizeThreadPool pool;

    public Worker(FixedSizeThreadPool pool){
       this.pool =  pool;
    }

    @Override
    public void run() {
        while (pool.isworking||pool.queue.size()>0){
            Runnable task = null;
            try {
                if (pool.isworking) {
                        task = pool.queue.take();//阻塞方式拿，拿不到一直等待
                }else{
                        task  = this.pool.queue.poll();
                }

            }catch (Exception e){
                e.printStackTrace();
            }
            if (task!=null){
                task.run();
                System.out.println("线程"+Thread.currentThread().getName()+"执行完毕");
            }

        }

    }
}