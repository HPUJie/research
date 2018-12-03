package com.hapi;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.zookeeper.CreateMode;

import java.util.concurrent.TimeUnit;

public class CuratorEnvent {
    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = Curator.getInstence();
        PathChildrenCache cache = new PathChildrenCache(curatorFramework,"/event",true);
        cache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);

        cache.getListenable().addListener((curatorFramework1,pathChildrenCacheEvent)->{
            switch (pathChildrenCacheEvent.getType()){
                case CHILD_ADDED:
                    System.out.println("增加子节点");
                    break;
                case CHILD_REMOVED:
                    System.out.println("删除子节点");
                    break;
                case CHILD_UPDATED:
                    System.out.println("更新子节点");
                    break;
                default:break;
            }
        });

        curatorFramework.create().withMode(CreateMode.PERSISTENT).forPath("/node","event".getBytes());
        TimeUnit.SECONDS.sleep(1);
        System.out.println("1");
        curatorFramework.create().withMode(CreateMode.EPHEMERAL).forPath("/node/event1","1".getBytes());
        TimeUnit.SECONDS.sleep(1);
        System.out.println("2");

        curatorFramework.setData().forPath("/node/event1","222".getBytes());
        TimeUnit.SECONDS.sleep(1);
        System.out.println("3");

        curatorFramework.delete().forPath("/node/event1");
        System.out.println("4");

        System.in.read();
    }
}
