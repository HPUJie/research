package com.hapi.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by helo on 2018/12/9.
 */
public class VehicalInvacationHandler implements InvocationHandler {

    private final IVehical vehical;

    public VehicalInvacationHandler(IVehical vehical) {
        this.vehical = vehical;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {

        System.out.println("--before running...");
        Object ret = method.invoke(vehical, args);
        System.out.println("--after running...");

        return ret;
    }

}
