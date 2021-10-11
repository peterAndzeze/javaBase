package com.io.jdk;

/**
 * @className: TimeServer
 * @description: java Nio 模拟
 * @author: sw
 * @date: 2021/10/9
 **/
public class TimeServer {


    public static void main(String[] args) {
        int port=8080;
        MultiplexerTimeServer multiplexerTimeServer=new MultiplexerTimeServer(port);
        new Thread(multiplexerTimeServer).start();
    }
}
