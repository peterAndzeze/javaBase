package com.customer.thread.producerandconsumer;

public class PCThreadMain2 {
    public static void main(String[] args) throws InterruptedException {
        TaskQueue2 taskQueue =new TaskQueue2();
        for (int i = 0; i <3 ; i++) {
            new ProducerThread(taskQueue).start();
        }
        for (int i = 0; i <5 ; i++) {
            new ConsumerThread(taskQueue).start();
        }
        Thread.sleep(10000);
        // 进程结束
        System.exit(0);

    }
}
