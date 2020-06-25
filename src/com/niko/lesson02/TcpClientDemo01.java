package com.niko.lesson02;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @auther Daisy
 * @date 2020/6/25 - 10:14
 * 客户端
 */
public class TcpClientDemo01 {
    public static void main(String[] args) {

        InetAddress serverIP = null;
        Socket socket = null;
        OutputStream os = null;
        try {
            //1、要知道服务器的地址
            serverIP = InetAddress.getByName("127.0.0.1");
            int port = 9999;
            //2、创建一个socket连接
            socket = new Socket(serverIP,port);
            //3、发送消息 IO流
            os = socket.getOutputStream();
            os.write("你好，欢迎学习".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
