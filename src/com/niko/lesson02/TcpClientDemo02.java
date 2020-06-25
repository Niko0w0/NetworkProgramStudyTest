package com.niko.lesson02;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @auther Daisy
 * @date 2020/6/25 - 10:40
 */
public class TcpClientDemo02 {
    public static void main(String[] args) throws Exception{
        //创建一个socket连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9000);

        //2、创建一个输出流
        OutputStream os = socket.getOutputStream();

        //3、读取文件
        FileInputStream fis = new FileInputStream(new File("dairy.png"));

        //4、写出文件
        byte[] buffer = new byte[1024];
        int len;
        while((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
        //通知服务器，我已经发送文件
        socket.shutdownOutput();//我已经传输完了

        //确定服务器接收完毕，才能断开连接
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len2;
        byte[] buffer2 = new byte[2014];
        while((len2 = is.read(buffer2))!=-1){
            baos.write(buffer2,0,len2);
        }
        System.out.println(baos.toString());

        //5、关闭资源
        baos.close();
        is.close();
        fis.close();
        os.close();
        socket.close();
    }
}
