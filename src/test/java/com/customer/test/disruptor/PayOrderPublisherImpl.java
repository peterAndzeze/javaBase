package com.customer.test.disruptor;

import com.customer.thread.disruptor.DisruptorProviderManage;
import com.customer.thread.disruptor.executor.DataConsumerExecutor;
import com.customer.thread.disruptor.provider.DisruptorProvider;
import com.customer.thread.disruptor.publisher.DataPublisher;

import java.util.Collections;
import java.util.List;

/**
 * 定义数据发布
 */
public class PayOrderPublisherImpl implements DataPublisher<PayOrder> {
    private DisruptorProviderManage providerManage;

    private DataConsumerExecutor.DataExecutorFactory factory;

    public void start() {
        factory = new DataConsumerExecutor.DataExecutorFactory("异步通知");
        factory.addSubscribers(new  NotifyOrderSubscriber(),new HOrderSubscriber());
        providerManage = new DisruptorProviderManage(factory, 1, providerManage.DEFAULT_SIZE);
        providerManage.startup();
    }
    @Override
    public <T> void publish(T t) {
        DisruptorProvider<Object> provider = providerManage.getProvider();
        List<T> ts = Collections.singletonList(t);
        provider.onData(f -> f.setData(ts));
    }


    @Override
    public <T> void publishList(T t) {
        DisruptorProvider<Object> provider = providerManage.getProvider();
        provider.onData(f -> f.setData(t));
    }



    /**
     * 关闭线程
     */
    @Override
    public void close() {
        providerManage.getProvider().shutdown();
    }
}
