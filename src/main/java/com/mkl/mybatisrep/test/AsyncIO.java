/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mkl.mybatisrep.test;

/**
 *
 * @author Admin
 */
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import static java.lang.System.currentTimeMillis;

public class AsyncIO {

    int dbCallCount;

    public static void main(String[] args) throws InterruptedException {
        var asyncIO = new AsyncIO();
        long startTime = currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            CompletableFuture.runAsync(asyncIO::dbCall1);
            CompletableFuture.runAsync(asyncIO::dbCall2);
            CompletableFuture.runAsync(asyncIO::dbCall3);
        }
        ForkJoinPool.commonPool().awaitTermination(2, TimeUnit.MINUTES);
        System.out.printf("completed IO calls in %d ms\n", currentTimeMillis() - startTime);
    }

    private void genericDbCall(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
            System.out.printf("Completed db call #%d\n", ++dbCallCount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void dbCall1() {
        genericDbCall(1);
    }

    public void dbCall2() {
        genericDbCall(2);
    }

    public void dbCall3() {
        genericDbCall(3);
    }
}
