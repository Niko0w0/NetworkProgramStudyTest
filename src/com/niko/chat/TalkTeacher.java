package com.niko.chat;

/**
 * @auther Daisy
 * @date 2020/6/25 - 15:31
 */
public class TalkTeacher {
    public static void main(String[] args) {
        new Thread(new TalkSend(5555,"localhost",8888)).start();
        new Thread(new TalkReceive(9999,"学生")).start();
    }
}
