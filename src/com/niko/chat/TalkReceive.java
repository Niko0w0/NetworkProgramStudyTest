package com.niko.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @auther Daisy
 * @date 2020/6/25 - 15:22
 */
public class TalkReceive implements Runnable{
    DatagramSocket socket = null;
    private int port;
    private String msgFrom;

    public TalkReceive(int port,String msgFrom) {
        this.port = port;
        this.msgFrom = msgFrom;
        //ctrl+alt+t代码提示，看起来是可以自动写if，try/catch语句的快捷键
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while(true){
            try {
                //准备接受包裹
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container,0,container.length);
                socket.receive(packet);//阻塞式接受包裹

                //断开连接      bye
                byte[] data = packet.getData();
                String receiveData = new String(data,0,data.length);
                System.out.println(msgFrom + ":" + receiveData);

                if(receiveData.trim().equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
