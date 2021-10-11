package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        LongAdder stat = new LongAdder();

        Shop shop1 = new Shop();
        Shop shop2 = new Shop();
        Shop shop3 = new Shop();

        Thread thread1 = new Thread("Магазин1");
        Thread thread2 = new Thread("Магазин2");
        Thread thread3 = new Thread("Магазин3");

        thread1.start();
        thread2.start();
        thread3.start();

        thread3.join();
        thread2.join();
        thread1.join();

        executorService.submit(() -> stat.add(shop1.countMoney()));
        executorService.submit(() -> stat.add(shop2.countMoney()));
        executorService.submit(() -> stat.add(shop3.countMoney()));
        executorService.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println("\nРезультат: " + stat.sum());
        executorService.shutdown();
    }
}
