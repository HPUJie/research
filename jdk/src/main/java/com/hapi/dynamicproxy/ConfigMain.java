package com.hapi.dynamicproxy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by helo on 2018/12/9.
 */
public class ConfigMain {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        IConfig config = ConfigFactory.create(new FileInputStream("G:\\config.properties"));
        String dbUrl = config.dbUrl();
        boolean isLoginValidated = config.isValidated();
        int dbPoolSize = config.poolSize();

    }
}
