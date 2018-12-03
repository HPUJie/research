package com.hapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Clone {
    public static void main(String[] args){
        Student student1 = new Student();
        student1.setName("zs");
        student1.setScore(90);
        student1.setAge(15);

        Student student2 = new Student();
        student2.setScore(80);
        student2.setName("ls");
        student2.setAge(16);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        Class class1 = new Class();
        class1.setName("四二班");
        class1.setNo(42);
        class1.setNum(2);
        class1.setStudent(student1);

        Class class2 = null;
        try {
            class2 = class1.deepClone(class1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        class1.setNum(3);
        class1.getStudent().setAge(25);

        System.out.println(class1);
        System.out.println(class2);
    }
}
