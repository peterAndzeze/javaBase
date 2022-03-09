package com.customer.nioreactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * reactor 单线程 模拟
 */
public class EchoServerReactor implements Runnable{
   // java nio selector
    Selector selector;

    ServerSocketChannel serverSocketChannel;

    public EchoServerReactor() throws IOException {
        serverSocketChannel=ServerSocketChannel.open().bind(new InetSocketAddress(8989));

    }

    @Override
    public void run() {

    }

    public static void main(String[] args) {
        String testStr="85";
        System.out.println(testStr.hashCode());
        switch (testStr){
            case "90":
                System.out.println("90");
            case "85":
                System.out.println("85");

            default:
                System.out.println("100");
        }



    }

}
