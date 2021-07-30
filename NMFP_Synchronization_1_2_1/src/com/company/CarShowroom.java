package com.company;

import java.util.ArrayList;
import java.util.List;

public class CarShowroom {

    Customer customer = new Customer(this);
    List<Car> cars = new ArrayList<>(1);

    public Car sellCar() {
        return customer.sellCar();
    }

    public void acceptCar() {
        customer.releaseCar();
    }

    List<Car> getCars() {
        return cars;
    }
}
