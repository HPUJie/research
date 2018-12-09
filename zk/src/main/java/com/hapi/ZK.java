package com.hapi;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ZK {
    private static String server = "192.168.37.128:2181,192.168.37.129:2181,192.168.37.130:2181";
    private static CountDownLatch countDownLatch=new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        ZkClient zkClient = new ZkClient(server,5000);
        /*zkClient.createPersistent("/node/cnode1/ccnode1",true);
        System.out.println("success");

        zkClient.delete("/node/cnode1/ccnode1");*/
        List<String>  strings = zkClient.getChildren("/node");
        for (String str:strings){
            System.out.println(str);
        }


        zkClient.subscribeDataChanges("/node", new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println("节点：" + s + ",修改后值：" + o);
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {

            }
        });

        zkClient.writeData("/node","123");
        TimeUnit.SECONDS.sleep(2);
        countDownLatch.countDown();
    }
}
