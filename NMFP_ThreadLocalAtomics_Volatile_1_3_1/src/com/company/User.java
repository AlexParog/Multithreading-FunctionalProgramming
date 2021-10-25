package com.company;

public class User {

    private Toy toy;

    public User(Toy toy) {
        this.toy = toy;
    }

    public void turnOn() throws InterruptedException {
        while (!Thread.currentThread().isInterrupted()) {
            if (toy.isTUMBLER()) toy.turnOffTumbler();
        }
    }

    public void turnOff() throws InterruptedException {
        while (!Thread.currentThread().isInterrupted()) {
            if (!toy.isTUMBLER()) toy.turnOnTumbler();
        }
    }
}
