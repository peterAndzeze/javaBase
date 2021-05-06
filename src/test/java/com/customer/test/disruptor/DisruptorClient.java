package com.customer.test.disruptor;

import java.util.ArrayList;
import java.util.List;

public class DisruptorClient {
    public static void main(String[] args) {

        /**
         * 启动生产者
         */
        PayOrderPublisherImpl payOrderPublisher = new PayOrderPublisherImpl();
        //list
        payOrderPublisher.start();
        List<PayOrder> payOrders=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            PayOrder p=new PayOrder();
            p.setAmt(i+"");
            p.setName("name:"+i);
            payOrders.add(p);
        }
        payOrderPublisher.publishList(payOrders);


        payOrderPublisher.start();
        List<PayHOrder> payhOrders=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            PayHOrder p=new PayHOrder();
            p.setAmt(i+"");
            p.setName("name:"+i);
            payhOrders.add(p);
        }
        payOrderPublisher.publishList(payhOrders);




    }

}
