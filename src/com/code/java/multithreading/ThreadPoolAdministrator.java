package com.code.java.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolAdministrator {
    static int count = 0;

    private static synchronized void incrementCounter() {
        count++;
    }

    private static synchronized int getCounter() {
        return count;
    }

    private static void doSomeAdminStuff() {}

    public void executeAdmin() {
        ExecutorService administrators = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            administrators.execute(() -> {
                //Admin start working
                for (int n = 0; n < 100; n++) {
                    doSomeAdminStuff();
                    incrementCounter();
                }
            });
        }
        System.out.printf("Count of Clients: %s\n", getCounter());
    }
}
