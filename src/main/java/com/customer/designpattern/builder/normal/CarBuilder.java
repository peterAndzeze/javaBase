package com.customer.designpattern.builder.normal;

import java.util.List;

/**
 * 汽车建造抽象类
 */
public abstract class CarBuilder {
    /**
     * 定义汽车建造需要的步骤
     * @param sequence
     */
    public abstract void setSequence(List<String> sequence);

    /**
     * 构建具体车量模型
     * @return
     */
    public abstract CarModel getCarModel();

}
