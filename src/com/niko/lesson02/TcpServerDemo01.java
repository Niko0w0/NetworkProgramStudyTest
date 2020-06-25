package com.niko.lesson02;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @auther Daisy
 * @date 2020/6/25 - 10:15
 * 服务端
 */
public class TcpServerDemo01 {
    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        try {
            //1、我得有个地址
            serverSocket = new ServerSocket(9999);
            while (true) {
                //2、等待客户端连接过来
                socket = serverSocket.accept();
                //3、读取客户端的消息
                is = socket.getInputStream();

                //管道流
                baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while((len=is.read(buffer))!= -1){
                    baos.write(buffer,0,len);
                }
                System.out.println(baos.toString());
            }


            /**
             byte[] buffer = new byte[1024];
             int len;
             while((len=is.read(buffer))!= -1){
             String msg = new String(buffer,0,len);
             System.out.println(msg);
             }
             */


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            try {
                if(baos!=null){
                    baos.close();
                }
                if(is!=null){
                    is.close();
                }
                if(socket!=null){
                    socket.close();
                }
                if(serverSocket!=null){
                    serverSocket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
