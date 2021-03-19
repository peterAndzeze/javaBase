package com.customer.designpattern.builder.special;

import com.customer.designpattern.builder.normal.BMWModel;
import com.customer.designpattern.builder.normal.BWMBuilder;
import com.customer.designpattern.builder.normal.BenzBuilder;
import com.customer.designpattern.builder.normal.BenzModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义指挥者
 */
public class Director {
    private List<String> sequence=new ArrayList<>();
    private BenzBuilder benzBuilder=new BenzBuilder();
    private BWMBuilder bwmBuilder=new BWMBuilder();

    /**
     * 定义A类宝马车
     * @return
     */
    public BMWModel getABwModel(){
        this.sequence.clear();
        sequence.add("start");
        this.bwmBuilder.setSequence(this.sequence);
        return (BMWModel) this.bwmBuilder.getCarModel();
    }

    /**
     * 创建c类奔驰车
     * @return
     */
    public BenzModel getCBenzModel(){
        this.sequence.clear();
        sequence.add("alarm");
        this.benzBuilder.setSequence(this.sequence);
        return (BenzModel) this.benzBuilder.getCarModel();
    }
}
