package com.hapi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Serial {
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
        //class1.setStudents(students);


        try {
            /*ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("Student")));
            oo.writeObject(class1);
            oo.close();*/

            ObjectInputStream oi = new ObjectInputStream(new FileInputStream(new File("Student")));
            Class cl2 = (Class) oi.readObject();

            //cl2.getStudents();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


}
