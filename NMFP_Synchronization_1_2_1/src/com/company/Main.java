package com.company;

public class Main {

    public static void main(String[] args) {

        final CarShowroom carShowroom = new CarShowroom();

        new Thread(null, carShowroom::sellCar, "Покупатель1").start();
        new Thread(null, carShowroom::sellCar, "Покупатель2").start();
        new Thread(null, carShowroom::sellCar, "Покупатель3").start();

        new Thread(null, carShowroom::acceptCar, "Автосалон1").start();
        new Thread(null, carShowroom::acceptCar, "Автосалон2").start();
        new Thread(null, carShowroom::acceptCar, "Автосалон3").start();

    }
}
