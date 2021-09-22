package com.company;

public class User {

    private static final int TIME = 4000;
    private static final boolean SET_TUMBLER_TRUE = true;

    private Toy toy = new Toy();
    private int count = 0;


    public void turnOnTumbler() throws InterruptedException {
        while (count < 5) {
            Thread.sleep(TIME);
            System.out.printf("%s: включил тумблер!\n", Thread.currentThread().getName());
            toy.setTUMBLER(SET_TUMBLER_TRUE);
            count++;
        }
        System.out.printf("%s: прекращаю работу, устал играться...\n", Thread.currentThread().getName());
        Thread.currentThread().interrupt();
    }
}
