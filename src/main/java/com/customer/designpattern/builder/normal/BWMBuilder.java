package com.customer.designpattern.builder.normal;

import java.util.List;

/**
 * 宝马建造抽象类
 */
public  class BWMBuilder extends CarBuilder  {
    /**
     * 奔驰车模型实例
     */
    private BMWModel bmwModel=new BMWModel();

    @Override
    public void setSequence(List<String> sequence) {
        this.bmwModel.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return this.bmwModel;
    }
}
