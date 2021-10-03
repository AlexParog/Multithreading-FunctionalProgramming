package com.company;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class StreamATC {

    private final String[] ELEMENTS = new String[40];

    private final BlockingQueue<String> calls = new LinkedBlockingQueue<String>(40);

    public StreamATC() {
        generateCalls();
    }

    public BlockingQueue<String> getCalls() {
        return calls;
    }

    public void generateCalls() {
        for (int i = 0; i < ELEMENTS.length; i++) {
            ELEMENTS[i] = "Звонок " + i;
        }
        calls.addAll(Arrays.asList(ELEMENTS));
    }
}
