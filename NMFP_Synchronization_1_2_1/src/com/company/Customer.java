package com.company;

public class Customer {

    private CarShowroom carShowroom;

    public Customer(CarShowroom carShowroom) {
        this.carShowroom = carShowroom;
    }

    public synchronized Car sellCar() {
        try {
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
            while (carShowroom.getCars().size() == 0) {
                System.out.println("Автосалон: машин нет...");
                wait();
            }
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " приобрел машину");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return carShowroom.getCars().remove(0);
    }

    public synchronized void releaseCar() {
        try {
            System.out.println("Производитель " + Thread.currentThread().getName() + " выпустил 1 авто...");
            Thread.sleep(3000);
            carShowroom.getCars().add(new Car());
            System.out.println("Автосалон: машина в автосалоне...");
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
