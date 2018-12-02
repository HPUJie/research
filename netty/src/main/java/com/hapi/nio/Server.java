package com.hapi.nio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by helo on 2018/12/2.
 */
public class Server {


    public static void main(String[] args){
        ServerHandle serverHandle = new ServerHandle(8080);
        Thread thread = new Thread(serverHandle);
        thread.start();
    }
}
