package com.customer.designpattern.builder.normal;

import java.util.Arrays;
import java.util.List;

/**
 * 建造者客户端测试
 */
public class ClientBuilder {

    public static void main(String[] args) {
        List<String> sequence= Arrays.asList("start","alarm","stop");
        BenzBuilder benzBuilder=new BenzBuilder();
        benzBuilder.setSequence(sequence);
        benzBuilder.getCarModel().run();

    }
}
