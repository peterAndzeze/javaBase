package com.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @version 1.0
 * @description: 模拟客户端
 * @author: sw
 * @date 2022-03-09
 */
public class NioClient {
    public static void main(String[] args) throws IOException {
        //1、链接服务端
        SocketChannel socketChannel=SocketChannel.open();
        //
        socketChannel.connect(new InetSocketAddress("localhost",9999));
        // 2、发送消息
        socketChannel.write(ByteBuffer.wrap("你好吗?".getBytes(StandardCharsets.UTF_8)));
        //3、接收服务端返回
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        int read = socketChannel.read(allocate);
        String s = new String(allocate.array(), 0, read, StandardCharsets.UTF_8);
        System.out.println("服务端返回:"+s);
    }
}
