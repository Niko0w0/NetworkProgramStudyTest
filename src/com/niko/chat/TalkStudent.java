package com.niko.chat;

/**
 * @auther Daisy
 * @date 2020/6/25 - 15:29
 */
public class TalkStudent {
    public static void main(String[] args) {
        //开启两个线程
        new Thread(new TalkSend(7777,"localhost",9999)).start();
        new Thread(new TalkReceive(8888,"老师")).start();
    }
}
