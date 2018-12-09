package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Test implements Callable {
    @Override
    public Object call() throws Exception {
        return "this is callable";
    }
}
