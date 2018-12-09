package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FindMaxTask implements Callable<Integer> {

    private int[] data;
    private int start;
    private int end;

    FindMaxTask(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    public Integer call() throws InterruptedException {
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            if (data[i] > max) max = data[i];
        }
        TimeUnit.SECONDS.sleep(5);
        return max;
    }
}
