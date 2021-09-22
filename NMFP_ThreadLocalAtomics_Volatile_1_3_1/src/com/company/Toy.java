package com.company;

public class Toy {
    private static final int TIME = 4000;
    private static final boolean SET_TUMBLER_FALSE = false;

    private volatile boolean TUMBLER = false;

    public Toy() {
    }

    public boolean isTUMBLER() {
        return TUMBLER;
    }

    public void setTUMBLER(boolean TUMBLER) {
        this.TUMBLER = TUMBLER;
    }

    public void turnOffTumbler() throws InterruptedException {
        Thread.sleep(TIME);
        System.out.printf("%s: возвращаю обратно!\n", Thread.currentThread().getName());
        setTUMBLER(SET_TUMBLER_FALSE);
    }
}
