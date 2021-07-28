package com.company;

public class Main {

    private static final Logger LOGGER = Logger.getInstance();

    public static void main(String[] args) throws Exception {

        ThreadGroup mainGroup = new ThreadGroup("main group");
        ThreadGroup group1 = new ThreadGroup(mainGroup,"group 1");
        ThreadGroup group2 = new ThreadGroup(mainGroup,"group 2");
        ThreadGroup group3 = new ThreadGroup(mainGroup,"group 3");
        ThreadGroup group4 = new ThreadGroup(mainGroup,"group 4");

        MyThread threadOne = new MyThread();
        threadOne.setName("Я поток 1.");
        MyThread threadTwo = new MyThread();
        threadTwo.setName("Я поток 2.");
        MyThread threadThree = new MyThread();
        threadThree.setName("Я поток 3.");
        MyThread threadFour = new MyThread();
        threadFour.setName("Я поток 4.");

        final Thread thread1 = new Thread(group1, threadOne);
        final Thread thread2 = new Thread(group2, threadTwo);
        final Thread thread3 = new Thread(group3, threadThree);
        final Thread thread4 = new Thread(group4, threadFour);

        LOGGER.log("Создаю потоки...");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();


        mainGroup.interrupt();
        LOGGER.log("Завершаю все потоки.");
    }
}
