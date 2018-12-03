package com.hapi;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class Curator {

    private static String server = "192.168.37.128:2181,192.168.37.129:2181,192.168.37.130:2181";

    public static CuratorFramework getInstence(){
        CuratorFramework curatorFramework = CuratorFrameworkFactory.
                newClient(server,5000,5000,new ExponentialBackoffRetry(1000,3));
        curatorFramework.start();
        return curatorFramework;
    }

}
