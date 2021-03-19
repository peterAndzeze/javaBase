package com.customer.designpattern.builder.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * 普通版 汽车模型
 */
public abstract class CarModel {
    /**
     * 组装方法执行顺序
     */
    public List<String> sequence=new ArrayList<>();

    /**
     * 启动
     */
    protected abstract void start();

    /**
     * 停止
     */
    protected abstract void stop();

    /**
     * 鸣笛
     */
    protected abstract void alarm();

    /**
     * 定义顺序
     * @param sequence
     */
     final public void setSequence(List<String> sequence) {
        this.sequence = sequence;
    }

    final public void run(){
        int nums=this.sequence.size();
        String actionMethod=null;
        for (int i = 0; i <nums ; i++) {
            actionMethod=sequence.get(i);
            if(actionMethod.equalsIgnoreCase("start")){
                this.start();
            }else if(actionMethod.equalsIgnoreCase("alarm")){
                this.alarm();
            }else if(actionMethod.equalsIgnoreCase("stop")){
                this.stop();
            }
        }
    }




}
