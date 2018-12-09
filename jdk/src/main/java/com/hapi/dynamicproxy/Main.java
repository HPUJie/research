package com.hapi.dynamicproxy;

/**
 * Created by helo on 2018/12/9.
 */
public class Main {
    public static void main(String[] args) {

        IVehical car = new Car();
        VehicalProxy proxy = new VehicalProxy(car);

        IVehical proxyObj = proxy.create();
        proxyObj.run();
    }
}
