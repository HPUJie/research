package com.hapi.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by helo on 2018/12/9.
 */
public class VehicalProxy {
    private IVehical vehical;

    public VehicalProxy(IVehical vehical) {
        this.vehical = vehical;
    }

    public IVehical create(){
        final Class<?>[] interfaces = new Class[]{IVehical.class};
        final VehicalInvacationHandler handler = new VehicalInvacationHandler(vehical);

        return (IVehical) Proxy.newProxyInstance(IVehical.class.getClassLoader(), interfaces, handler);
    }

}
