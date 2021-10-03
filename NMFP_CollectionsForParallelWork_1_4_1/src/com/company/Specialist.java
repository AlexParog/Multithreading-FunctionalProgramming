package com.company;

import java.util.concurrent.locks.ReentrantLock;

public class Specialist {

    public static final int MILLIS = 3000;

    private StreamATC streamATC = new StreamATC();

    public void workATC() {

        final ReentrantLock lock = new ReentrantLock();

        System.out.println("У колл-центра начинается рабочий день...");

        lock.lock();
        try {

            for (String call : streamATC.getCalls()) {
                System.out.printf("%s отвечает на %s\n", Thread.currentThread().getName(), call);
                streamATC.getCalls().offer(call);
                Thread.sleep(MILLIS);
                System.out.printf("%s взялся за следующий звонок...\n", Thread.currentThread().getName());
            }

        } catch (IllegalArgumentException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
