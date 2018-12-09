package com.hapi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

public class Test {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("H:\\test.peoperties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        fileInputStream.close();

        /*System.out.println(properties.getProperty("name"));
        System.out.println(properties.getProperty("age"));
        properties.put("sex","1");
        System.out.println(properties.getProperty("sex"));
        FileOutputStream fos = new FileOutputStream("H:\\test2.peoperties");
        properties.store(fos,"測試");*/

        /*Set<String> set = properties.stringPropertyNames();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
        /*Enumeration enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()){
            String key = (String) enumeration.nextElement();
            System.out.println(key);
            System.out.println(properties.getProperty(key));
        }*/


        ResourceBundle mybundle = ResourceBundle.getBundle("com.hapi.test");
        System.out.println(mybundle.getString("name"));

    }
}
