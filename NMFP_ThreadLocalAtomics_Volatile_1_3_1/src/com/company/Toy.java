package com.company;

public class Toy {

    private static final int TIME = 4000;
    private volatile boolean TUMBLER = true;

    private User user;

    public Toy(User user) {
        this.user = user;
    }

    public Toy() {
    }

    public boolean isTUMBLER() {
        return TUMBLER;
    }

    public void turnOnTumbler() throws InterruptedException {
        System.out.println("до" + TUMBLER);
        Thread.sleep(TIME);
        System.out.printf("%s: включил тумблер!\n", Thread.currentThread().getName());
        TUMBLER = true;
        System.out.println("после" + TUMBLER);

/*        System.out.printf("%s: прекращаю работу, устал играться...\n", Thread.currentThread().getName());
        Thread.currentThread().interrupt();*/
    }

    public void turnOffTumbler() throws InterruptedException {
        System.out.println("до" + TUMBLER);
        Thread.sleep(TIME);
        System.out.printf("%s: возвращаю обратно!\n", Thread.currentThread().getName());
        TUMBLER = false;
        System.out.println("после" + TUMBLER);
    }
}
