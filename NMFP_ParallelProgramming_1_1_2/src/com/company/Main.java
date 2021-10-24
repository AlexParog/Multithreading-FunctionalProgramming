package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<String> myCallable = new MyCallable();
        List<Callable<String>> callables = new ArrayList<>();
        callables.add(myCallable);

        // Создаем пул потоков фиксированного размера
        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        // Отправляем задачу в пул потоков
        final Future<String> task = threadPool.submit(myCallable);

        // Возврат первой успешно выполненной задачи
//        final String tasks = threadPool.invokeAny(callables);

        System.out.println(task.get());

        Thread.sleep(10000);

        threadPool.shutdown();
    }
}
