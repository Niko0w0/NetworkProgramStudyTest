package com.niko.lesson04;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @auther Daisy
 * @date 2020/6/25 - 16:58
 * http://localhost:8080/niko/SecurityFile.txt
 *
 * 告白网易云地址
 * https://m801.music.126.net/20200625174444/6d1978619444770e5f0a99dc44595ea6/jdyyaac/015b/5509/5459/61554bda73bc6e98b899c3ff41f97ae7.m4a
 */
public class URLDown {
    public static void main(String[] args) throws Exception {
        //1、下载地址
        URL url = new URL("https://m801.music.126.net/20200625174444/6d1978619444770e5f0a99dc44595ea6/jdyyaac/015b/5509/5459/61554bda73bc6e98b899c3ff41f97ae7.m4a");

        //2、连接到这个资源 HTTP
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        InputStream inputStream = urlConnection.getInputStream();

        FileOutputStream fos = new FileOutputStream("gaobai.m4a");

        byte[] buffer = new byte[1024];
        int len;
        while((len=inputStream.read(buffer))==-1){
            fos.write(buffer,0,len);//写出这个数据
        }
        fos.close();
        inputStream.close();
        urlConnection.disconnect();//断开连接
    }
}
