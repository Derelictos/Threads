package com.code.java.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolTheory {

    public ThreadPoolTheory() {
    }

    public void execute() {

        //---SingleThreadPool---
        //created ThreadPool with one Thread
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            //some code
            workingWithClients();
        });
        //another Thread working when another Thread will finish him work
        executorService.execute(() -> {
            //some code
            meetClients();
        });

        //------------------------------Here we didn't block work of first Thread-------------------------------
        //---Fixed ThreadPool---
        //now we create Thread with fixed count of thread's
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        fixedThreadPool.execute(() -> {
            //some code
            workingWithClients();
        });
        //create one more Thread, but it will work in one time in another Thread
        fixedThreadPool.execute(() -> {
            meetClients();
        });
        //create one more Thread if ThreadPoll are free
        fixedThreadPool.execute(() -> {
            doAnotherWork();
        });
        //And last is ScalableThreadPool
        //create scalableThreadPool
        ExecutorService scalableThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            final int tempi = i;
            scalableThreadPool.execute(() -> {
                //some code
                workingWithClients();
                System.out.printf("Number working Thread: %s\n", tempi);
            });
        }
        //create a little bit more aim's for thread
        for (int j = 0; j < 3; j++) {
            final int tempj = j;
            scalableThreadPool.execute(() -> {
                //some code
                doAnotherWork();
                System.out.printf("Number working Thread: %s\n", tempj);
            });
        }
        //create one more aim to meetClient
        scalableThreadPool.execute(() -> {
            meetClients();
        });
        //Now we can check count's created Thread's
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) scalableThreadPool;
        System.out.printf("Count of created threadpool: %s\n", threadPool);
        //-------------------------------Here is 3 type of Threads-----------------------------------------
    }

    private void doAnotherWork() {
        System.out.println("Thread are free, now we can do another work\n");
    }

    private void meetClients() {
        System.out.println("Now we ARE meeting our Clients\n");
    }

    private void workingWithClients() {
        System.out.println("We ARE working\n");
    }
}
