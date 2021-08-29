package com.company;

public class MyThread extends Thread {

    public MyThread() {
    }

    public MyThread(Runnable target) {
        super(target);
    }

    public MyThread(String name) {
        super(name);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
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
