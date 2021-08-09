package com.company;

public class MyThread extends Thread {

    public MyThread() {
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
    }

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
