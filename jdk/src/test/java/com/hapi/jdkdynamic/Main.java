package com.hapi.jdkdynamic;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Created by helo on 2018/12/12.
 */
public class Main {
    @Test
    public void test(){
        /*TestMapper testMapper = (TestMapper) Proxy.newProxyInstance(TestMapper.class.getClassLoader(),new Class[]{TestMapper.class},new MyInvokeHandler<TestMapper>(TestMapper.class));
        String name = testMapper.selectNameById(1);
        System.out.println("name:" + name);

        OrderMapper orderMapper = (OrderMapper) Proxy.newProxyInstance(OrderMapper.class.getClassLoader(),new Class[]{OrderMapper.class},new MyInvokeHandler<OrderMapper>(OrderMapper.class));
        int num = orderMapper.insertOrder();
        System.out.println("num:" + num);*/

        HPSqlSession hpSqlSession = new HPSqlSession();
        TestMapper testMapper1 = hpSqlSession.getMapper(TestMapper.class);
        Integer num = testMapper1.selectNameById(1);
        Integer no = testMapper1.selectNameByNo("55");
        System.out.println("num:" + num);
        System.out.println("no:" + no);

        OrderMapper orderMapper = hpSqlSession.getMapper(OrderMapper.class);
        int n = orderMapper.insertOrder();
        System.out.println("n:" + n);
    }
}
