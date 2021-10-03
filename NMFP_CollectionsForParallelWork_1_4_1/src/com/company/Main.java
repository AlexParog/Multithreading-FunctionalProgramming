package com.company;

// Для реализации данной задачи можно воспользоваться коллекцией LinkedBlockingQueue

public class Main {

    public static void main(String[] args) {
        Specialist specialist = new Specialist();

        new Thread(null, specialist::workATC, "Специалист1").start();

    }
}
