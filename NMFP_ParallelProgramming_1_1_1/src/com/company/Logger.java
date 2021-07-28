package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private final SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    private final Date date = new Date();
    protected int num = 1;
    private static Logger logger;

    private Logger() {
    }

    public static Logger getInstance() {
        if (logger == null) logger = new Logger();
        return logger;
    }

    public void log(String msg) {
        System.out.println("[" + formater.format(date) + " " + num++ + "] " + msg);
    }
}
