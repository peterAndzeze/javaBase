package com.customer.thread.producerandconsumer;

import java.util.Random;

/**
 * 生产者
 * @author sw
 */
public class ProducerThread extends Thread {
    private final TaskQueue taskQueue;
    private final Random random=new Random();
    private Integer index=0;
    public ProducerThread(TaskQueue taskQueue){
        this.taskQueue=taskQueue;
    }
    @Override
    public void run() {
       while (true){
           taskQueue.putData(index);
           System.out.println("添加元素:"+index);
           index++;
           try {
               Thread.sleep(random.nextInt(1000));
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}
