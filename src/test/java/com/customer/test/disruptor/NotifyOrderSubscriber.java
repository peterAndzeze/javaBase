package com.customer.test.disruptor;

import com.customer.thread.disruptor.executor.DataExecutorTypeSubscriber;

import java.util.Collection;

/**
 * 异步通知订单数据定于者
 */
public class NotifyOrderSubscriber implements DataExecutorTypeSubscriber<PayOrder> {


    /**
     * 执行订阅来的数据
     * @param dataList the data list
     */
    @Override
    public void executor(Collection<PayOrder> dataList) {
            dataList.forEach(this::doProcess);
    }

    /**
     * 业务执行
     * @param payOrders
     */
    private void doProcess(PayOrder payOrders) {
            System.out.println(payOrders.getName()+":::"+payOrders.getAmt());

    }


    @Override
    public DataType getType() {
        return DataType.PAY_ORDER;
    }
}


