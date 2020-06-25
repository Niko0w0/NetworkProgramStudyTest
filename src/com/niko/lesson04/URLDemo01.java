package com.niko.lesson04;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @auther Daisy
 * @date 2020/6/25 - 15:55
 */
public class URLDemo01 {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/helloworld.index.jsp?username=jkk&password=123");

        System.out.println(url.getProtocol());//协议
        System.out.println(url.getHost());//IP
        System.out.println(url.getPort());//端口
        System.out.println(url.getPath());//文件
        System.out.println(url.getFile());//全路径
        System.out.println(url.getQuery());//参数
    }
}
