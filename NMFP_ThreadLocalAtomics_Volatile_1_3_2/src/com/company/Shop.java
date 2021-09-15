package com.company;

import java.util.stream.IntStream;

public class Shop {

    private static final int MAX_VALUE = 1000;
    private static final int NUMBER = 5;

    private long money = 0;
    private final int[] window = new int[NUMBER];

    public void countMoney() {
        randomArray(window);
        System.out.printf("%s считает наличку\n", Thread.currentThread().getName());
        long result = IntStream.of(window).sum();
        System.out.printf("Теперь у %s %d рублей\n", Thread.currentThread().getName(), result);
    }

    public long getMoney() {
        return money;
    }

    public int[] randomArray(int[] array) {
        for (int i = 0; i < NUMBER; i++) {
            array[i] = (int) Math.round((Math.random() * MAX_VALUE));
        }
        return array;
    }
}
