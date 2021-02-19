package com.customer.thread.producerandconsumer;

/**
 * 任务数据存放
 * @author sw
 */
public class TaskQueue {
    /**
     * 任务数组
     */
    private Integer [] queue=new Integer[10];
    /***放入数据下标***/
    private Integer putIndex=0;
    /***数据长度***/
    private Integer dataLength=0;
    /***获取数据下标*****/
    private Integer getIndex=0;
    /***对象实例锁***/
    private Object lock=new Object();

    /**
     * 放入数据
     * @param element
     */
    public   synchronized void putData(Integer element) {
            /**等于最大长度**/
            if(dataLength==queue.length){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue[putIndex]=element;
            this.notify();
            ++putIndex;
            ++dataLength;
            /**放入数据等于数据最大长度**/
            if(putIndex==queue.length){
                putIndex=0;
            }

    }

    /**
     * 取数据
     * @return
     */
    public synchronized Integer getData(){
            if(dataLength==0){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Integer result=queue[getIndex];
            ++getIndex;
            if(getIndex==queue.length){
                getIndex=0;
            }
            --dataLength;
            notify();
            return result;
    }



}
