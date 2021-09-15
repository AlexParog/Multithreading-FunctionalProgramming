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

        Thread thread1 = new Thread(null, shop1::countMoney, "Магазин1");
        Thread thread2 = new Thread(null, shop2::countMoney, "Магазин2");
        Thread thread3 = new Thread(null, shop3::countMoney, "Магазин3");

        thread1.start();
        thread2.start();
        thread3.start();

        thread3.join();
        thread2.join();
        thread1.join();

        executorService.submit(() -> stat.add(shop1.getMoney()));
        executorService.submit(() -> stat.add(shop2.getMoney()));
        executorService.submit(() -> stat.add(shop3.getMoney()));
        executorService.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println("\nРезультат: " + stat.sum());
        executorService.shutdown();
    }
}
