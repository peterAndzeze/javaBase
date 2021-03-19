package com.customer.designpattern.builder.normal;

import java.util.List;

/**
 * 奔驰建造抽象类
 */
public  class BenzBuilder extends CarBuilder  {
    /**
     * 奔驰车模型实例
     */
    private BenzModel benzModel=new BenzModel();

    @Override
    public void setSequence(List<String> sequence) {
        this.benzModel.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return this.benzModel;
    }
}
