package com.hapi.jdkdynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by helo on 2018/12/12.
 */
public class MyInvokeHandler<T> implements InvocationHandler {

    private Class<T> mapper;

    private HPSqlSession hpSqlSession;

    public MyInvokeHandler(Class<T> mapper,HPSqlSession hpSqlSession) {
        this.mapper = mapper;
        this.hpSqlSession = hpSqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String key = method.getDeclaringClass().getName() + "." + method.getName();
        System.out.println("key:" + key);
        Object object = hpSqlSession.excutor(key);
        System.out.println("Ö´ÐÐ½á¹û:" + object);
        return object;
    }
}
