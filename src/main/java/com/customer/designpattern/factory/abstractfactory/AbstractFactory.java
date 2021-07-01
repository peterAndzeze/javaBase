package com.customer.designpattern.factory.abstractfactory;

import com.customer.designpattern.factory.abstractfactory.food.AbstractFood;
import com.customer.designpattern.factory.abstractfactory.shut.AbstractWeapon;
import com.customer.designpattern.factory.abstractfactory.vehicle.AbstractVehicle;

/**
 * 抽象工厂
 */
public abstract class AbstractFactory {
   public abstract AbstractVehicle createVehicle();
   public abstract AbstractFood createFood();
   public abstract AbstractWeapon createWeapon();

}
