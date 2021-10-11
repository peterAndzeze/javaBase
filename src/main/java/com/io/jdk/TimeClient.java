package com.io.jdk;

/**
 * @className: TimeServer
 * @description: java Nio 模拟
 * @author: sw
 * @date: 2021/10/9
 **/
public class TimeClient {


    public static void main(String[] args) {
        int port=8080;
        TimeClientHandler timeClientHandler=new TimeClientHandler("127.0.0.1",port);
        new Thread(timeClientHandler).start();
    }
}
