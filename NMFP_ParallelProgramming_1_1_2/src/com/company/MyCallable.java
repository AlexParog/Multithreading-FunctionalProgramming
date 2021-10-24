package com.company;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    public MyCallable() {
    }

    @Override
    public String call() {
        double random = Math.random() * 5;
        int count = 0;
        for (int i = 0; i < random; i++) {
            System.out.println("Сообщение" + i);
            count++;
        }
        return "Количество сообщений: " + count;
    }
}
