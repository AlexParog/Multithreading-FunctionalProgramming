package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Toy toy = new Toy();
        User user1 = new User();
        User user2 = new User();

        Thread threadToy = new Thread(null, () -> {
            try {
                toy.turnOffTumbler();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Игрушка");

        Thread threadUser1 = new Thread(null, () -> {
            try {
                user1.turnOnTumbler();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Пользователь1");

        while (!Thread.currentThread().isInterrupted()) {
            threadUser1.start();
            threadToy.start();

            threadToy.join();
            threadUser1.join();
        }
        Thread.currentThread().interrupt();
    }
}
