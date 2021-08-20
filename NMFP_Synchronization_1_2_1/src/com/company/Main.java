package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        final Customer customer = new Customer();
        List<Thread> threads = new ArrayList<>();

        while (!Thread.currentThread().isInterrupted()) {
            for (int i = 0; i <= 12; i++) {
                new Thread(null, customer::buyCar, "Покупатель" + i).start();
                new Thread(null, customer::acceptCar, "Автосалон1").start();
            }
            Thread.currentThread().interrupt();
        }
    }
}
