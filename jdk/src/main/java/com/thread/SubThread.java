package com.thread;

public class SubThread extends Thread {

    public SubThread(String msg) {
        this.msg = msg;
    }

    private String msg;

    public void run() {
        msg += " subthread modify";
        System.out.println(msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
