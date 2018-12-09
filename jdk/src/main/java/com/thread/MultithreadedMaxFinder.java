package com.thread;

import junit.framework.TestCase;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.Callable;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class MultithreadedMaxFinder extends TestCase {
    public static int max(int[] data) throws InterruptedException, ExecutionException {

        if (data.length == 1) {
            return data[0];
        } else if (data.length == 0) {
            throw new IllegalArgumentException();
        }

        // split the job into 2 pieces
        FindMaxTask task1 = new FindMaxTask(data, 0, data.length/2);
        FindMaxTask task2 = new FindMaxTask(data, data.length/2, data.length);

        // spawn 2 threads
        ExecutorService service = Executors.newFixedThreadPool(2);

        Future<Integer> future1 = service.submit(task1);
        Future<Integer> future2 = service.submit(task2);

        return Math.max(future1.get(), future2.get());
    }

    public void test() throws ExecutionException, InterruptedException {
        int[] data = {1,2,5,6,3,2,9};
        int masx = max(data);
        System.out.println(masx);
    }

    public void test2()  {
        Test test1 = new Test();
        ExecutorService  executorService = Executors.newFixedThreadPool(2);
        Future future = executorService.submit(test1);
        Future future2 = executorService.submit(test1);
        FutureTask futureTask = new FutureTask(test1);
        new Thread(futureTask).start();
        try {
            System.out.println(future.get());
            System.out.println(future2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
