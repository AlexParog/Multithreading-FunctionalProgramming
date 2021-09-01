package com.company;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    public MyCallable() {
    }

    @Override
    public String call() throws Exception {
        double random = Math.random() * 5;
        for (int i = 0; i < random; i++) {
            System.out.println("Сообщение" + i);
        }
        return "Количество сообщений: " + (int) random;
    }
}
