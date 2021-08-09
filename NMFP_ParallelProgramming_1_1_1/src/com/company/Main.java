package com.company;

public class Main {

    private static final Logger LOGGER = Logger.getInstance();

    public static void main(String[] args) throws Exception {

        ThreadGroup mainGroup = new ThreadGroup("main group");

        MyThread threadOne = new MyThread(mainGroup, Thread.currentThread());
        threadOne.setName("Я поток 1.");
        MyThread threadTwo = new MyThread(mainGroup, Thread.currentThread());
        threadTwo.setName("Я поток 2.");
        MyThread threadThree = new MyThread(mainGroup, Thread.currentThread());
        threadThree.setName("Я поток 3.");
        MyThread threadFour = new MyThread(mainGroup, Thread.currentThread());
        threadFour.setName("Я поток 4.");

        LOGGER.log("Создаю потоки...");

        threadOne.start();
        threadTwo.start();
        threadThree.start();
        threadFour.start();

        Thread.sleep(10000);
        mainGroup.interrupt();
    }
}
