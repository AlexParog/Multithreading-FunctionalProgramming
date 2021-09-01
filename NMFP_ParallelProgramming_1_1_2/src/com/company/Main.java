package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadGroup mainGroup = new ThreadGroup("main group");

        MyThread threadOne = new MyThread(mainGroup, Thread.currentThread());
        threadOne.setName("Я поток 1.");
        MyThread threadTwo = new MyThread(mainGroup, Thread.currentThread());
        threadTwo.setName("Я поток 2.");
        MyThread threadThree = new MyThread(mainGroup, Thread.currentThread());
        threadThree.setName("Я поток 3.");
        MyThread threadFour = new MyThread(mainGroup, Thread.currentThread());
        threadFour.setName("Я поток 4.");

        threadOne.start();
        threadTwo.start();
        threadThree.start();
        threadFour.start();

        // Создаем ОДНУ задачу с результатом типа String
        Callable<String> myCallable = new MyCallable();
        List<Callable<?>> callables = new ArrayList<>();
        callables.add(myCallable);

        // Создаем пул потоков фиксированного размера
        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        // Отправляем задачу в пул потоков
        final Future<String> task = threadPool.submit(myCallable);
        // Возврат первой успешно выполненной задачи
        final FutureTask<String> tasks = threadPool.invokeAny(callables);

        System.out.println(tasks.get());
        System.out.println(task.get());

        Thread.sleep(10000);

        mainGroup.interrupt();
        threadPool.shutdown();
    }
}
