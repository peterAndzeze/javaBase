package com.customer.designpattern.template;

import java.util.Arrays;
import java.util.List;

/**
 * 测试客户端
 */
public class ClientTemplate {

    public static void main(String[] args) {
        BenzModel benzModel=new BenzModel();
        List<String> sequence= Arrays.asList("start","stop","alarm");
        benzModel.setSequence(sequence);
        /**
         * 奔驰车不鸣笛
         */
        benzModel.setAlarm(false);
        benzModel.run();


        BMWModel bmwModel=new BMWModel();
        List<String> sequencea= Arrays.asList("start","stop","alarm");
        bmwModel.setSequence(sequencea);
        /**
         * 宝马车不鸣笛
         */
        bmwModel.setAlarm(true);
        bmwModel.run();


    }
}
