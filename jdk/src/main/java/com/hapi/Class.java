package com.hapi;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Class implements Serializable {
    private static final long serialVersionUID = -1840434472873370636L;
    private Integer no;
    private String name;
    private int num;
    private Student student;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Class{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", student=" + student +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Class cl = (Class) super.clone();
        cl.student = (Student) student.clone();
        return cl;
    }

    public Class deepClone(Class clas) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream ba = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(ba);
        oo.writeObject(clas);

        ObjectInputStream oi = new ObjectInputStream(new ByteArrayInputStream(ba.toByteArray()));
        Class cla = (Class) oi.readObject();
        return cla;
    }
}
