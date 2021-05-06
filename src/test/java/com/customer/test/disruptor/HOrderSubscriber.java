package com.customer.test.disruptor;

import com.customer.thread.disruptor.executor.DataExecutorTypeSubscriber;

import java.util.Collection;

/**
 * 异步通知订单数据定于者
 */
public class HOrderSubscriber implements DataExecutorTypeSubscriber<PayHOrder> {


    /**
     * 执行订阅来的数据
     * @param dataList the data list
     */
    @Override
    public void executor(Collection<PayHOrder> dataList) {
            dataList.forEach(this::doProcess);
    }

    /**
     * 业务执行
     * @param payOrders
     */
    private void doProcess(PayHOrder payOrders) {
            System.out.println("还款"+payOrders.getName()+":::"+payOrders.getAmt());

    }


    @Override
    public DataType getType() {
        return DataType.H_ORDER;
    }
}


