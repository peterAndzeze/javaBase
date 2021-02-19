package com.customer.thread.producerandconsumer;

import java.util.Random;

/**
 * 消费者
 * @author sw
 */
public class ConsumerThread extends Thread {
    private final TaskQueue taskQueue;
    private final Random random = new Random();

    public ConsumerThread(TaskQueue taskQueue){
        this.taskQueue=taskQueue;
    }
    @Override
    public void run() {
       while (true){
           Integer data = taskQueue.getData();
           System.out.println(" \t \t 取出元素:"+data);
           try {
               Thread.sleep(random.nextInt(1000));
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}
