package com.company;

import java.util.ArrayList;
import java.util.List;

public class CarShowroom {

    public static final int PURCHASE = 3000;
    public static final int MACHINE_CREATION = 4000;

    private Customer customer;
    private List<Car> cars = new ArrayList<>(1);
    private int countMachine = 0;

    public CarShowroom() {
    }

    public CarShowroom(Customer customer) {
        this.customer = customer;
    }

    public synchronized Car sellCar() {
        try {
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
            if (!Thread.currentThread().isInterrupted()) {
                while (cars.size() == 0) {
                    System.out.println("Автосалон: машин нет...");
                    wait();
                }
                Thread.sleep(PURCHASE);
                System.out.println(Thread.currentThread().getName() + " приобрел машину");
            } else Thread.currentThread().interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return cars.remove(0);
    }

    public synchronized void releaseCar() {
        try {
            if (countMachine < 10 && !Thread.currentThread().isInterrupted()) {
                System.out.println("Производитель " + Thread.currentThread().getName() + " выпустил 1 авто...");
                Thread.sleep(MACHINE_CREATION);
                countMachine++;
                cars.add(new Car());
                System.out.println("Автосалон: машина в автосалоне...");
                System.out.println("Автосалон: машин произведено - " + countMachine);
                notifyAll();
            } else {
                System.out.println("Автосалон: ПРОИЗВЕДЕНО МАКСИМАЛЬНОЕ КОЛИЧЕСТВО АВТОМОБИЛЕЙ!");
                Thread.currentThread().interrupt();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getSoldCars() {
        return countMachine;
    }
}
