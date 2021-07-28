package com.company;

public class MyThread extends Thread {

    @Override
    public void run() {

        try {
            while (!isInterrupted()) {
                Thread.sleep(2500);
                System.out.println(getName() + "Всем привет!");
            }
        } catch (InterruptedException e) {

        } finally {
            System.out.printf("%s Завершен\n", getName());
        }

    }
}
