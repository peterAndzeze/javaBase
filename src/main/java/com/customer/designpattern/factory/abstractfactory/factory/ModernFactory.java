package com.customer.designpattern.factory.abstractfactory.factory;


import com.customer.designpattern.factory.abstractfactory.AbstractFactory;
import com.customer.designpattern.factory.abstractfactory.food.AbstractFood;
import com.customer.designpattern.factory.abstractfactory.food.DanGao;
import com.customer.designpattern.factory.abstractfactory.shut.AbstractWeapon;
import com.customer.designpattern.factory.abstractfactory.shut.JiaTeLin;
import com.customer.designpattern.factory.abstractfactory.vehicle.AbstractVehicle;
import com.customer.designpattern.factory.abstractfactory.vehicle.Car;

public class ModernFactory extends AbstractFactory {
    @Override
    public AbstractVehicle createVehicle() {
        return new Car();
    }

    @Override
    public AbstractFood createFood() {
        return new DanGao();
    }

    @Override
    public AbstractWeapon createWeapon() {
        return new JiaTeLin();
    }
}
