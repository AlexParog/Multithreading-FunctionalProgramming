package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        User user1 = new User();
        User user2 = new User();

        Thread threadUser1 = new Thread(null, () -> {
            try {
                user1.turnOnOrTurnOff();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "User1");

        Thread threadUser2 = new Thread(null, () -> {
            try {
                user2.turnOnOrTurnOff();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "User2");

        threadUser1.start();
        threadUser1.join();

        threadUser2.start();
        threadUser2.join();

    }
}
