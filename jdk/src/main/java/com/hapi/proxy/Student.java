package com.hapi.proxy;

/**
 * Created by helo on 2018/12/9.
 */
public class Student implements Person {
    private String name;
    public Student(String name) {
        this.name = name;
    }

    public void giveMoney() {
        System.out.println(name + "上交班费50元");
    }
}
