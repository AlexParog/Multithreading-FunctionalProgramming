package com.company;

public class User {

    private Toy toy;
    private volatile int COUNTER = 0;


    public User(Toy toy) {
        this.toy = toy;
    }

    public void turnOnOrTurnOff() throws InterruptedException {
        while (COUNTER < 5) {

            if (toy.isTUMBLER()) {
                COUNTER++;
                toy.turnOffTumbler();
            } else if (!toy.isTUMBLER()) {
                COUNTER++;
                toy.turnOnTumbler();
            }

            System.out.printf("%s: прекращаю работу, устал играться...\n", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }

    }
}
