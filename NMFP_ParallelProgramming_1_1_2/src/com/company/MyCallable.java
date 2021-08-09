package com.company;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    public MyCallable() {
    }

    @Override
    public String call() throws Exception {
        System.out.println();
        return "Result";
    }
}
