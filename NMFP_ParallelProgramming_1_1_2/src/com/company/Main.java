package com.company;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Создаем задачу с результатом типа String
        Callable<String> myCallable = new MyCallable();

        // Создаем пул потоков фиксированного размера
        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        final FutureTask<String> tasks = threadPool.invokeAny(threadPool);

        MyThread threadOne = new MyThread();
        threadOne.setName("Я поток 1.");
        MyThread threadTwo = new MyThread();
        threadTwo.setName("Я поток 2.");
        MyThread threadThree = new MyThread();
        threadThree.setName("Я поток 3.");
        MyThread threadFour = new MyThread();
        threadFour.setName("Я поток 4.");

        threadPool.shutdown();
    }
}
