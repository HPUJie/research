package com.hapi.proxy.dynamic;

/**
 * Created by helo on 2018/12/9.
 */
public class MonitorUtil {

    private static ThreadLocal<Long> tl = new ThreadLocal<Long>();

    public static void start() {
        tl.set(System.currentTimeMillis());
    }

    //结束时打印耗时
    public static void finish(String methodName) {
        long finishTime = System.currentTimeMillis();
        System.out.println(methodName + "方法耗时" + (finishTime - tl.get()) + "ms");
    }
}