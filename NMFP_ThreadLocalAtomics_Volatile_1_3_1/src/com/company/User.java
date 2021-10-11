package com.company;

public class User {

    private Toy toy = new Toy(this);

    public void turnOnOrTurnOff() throws InterruptedException {
        if (toy.isTUMBLER()) {
            toy.turnOffTumbler();
        } else toy.turnOnTumbler();
    }
}
