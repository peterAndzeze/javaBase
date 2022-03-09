package com.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @version 1.0
 * @description: NIO 服务端
 * @author: sw
 * @date 2022-03-09
 */
public class NioServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(9999));
        // true 是同步阻塞  false 是异步阻塞 默认是 同步
        serverSocketChannel.configureBlocking(false);
        while (true){
            SocketChannel accept = serverSocketChannel.accept();
            if(null==accept){
                Thread.sleep(3000);
                System.out.println("暂无连接信息 *****8");
                continue;
            }
            // 拿到客户端链接
            // 1、申请内存中的缓冲区空间
            ByteBuffer allocate = ByteBuffer.allocate(1024);
            // 大于1 读取到的数据 还有； 0 ：本次无内容  -1 ：读完了
            int read = accept.read(allocate);
            ByteBuffer wrap = ByteBuffer.wrap(allocate.array(), 0, read);
            System.out.println("接收到:"+new String(wrap.array(), StandardCharsets.UTF_8));
            // 模拟写出
            accept.write(ByteBuffer.wrap("你好骚啊".getBytes()));
        }
    }
}
