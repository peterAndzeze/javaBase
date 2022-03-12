package com.io.seclector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @version 1.0
 * @description: 服务端selector
 * @author: sw
 * @date 2022-03-09
 */
public class NioSelectorServer {
    public static void main(String[] args) throws IOException {
        // 1、打开服务端的一个通道
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        // 2、绑定端口
        serverSocketChannel.bind(new InetSocketAddress(9999));
        //3、通道默认是阻塞的 改为异步
        serverSocketChannel.configureBlocking(false);
        //4、 创建选择器
        Selector selector = Selector.open();
        //5 将服务端的通道注册到选择器上，并指定注册坚挺的事件为 op_accept
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务端启动完成******");
        while (true){
            //6 检查选择器是否有事件 (空转问题 epoll 类),此处会阻塞（）
            int select = selector.select(2000);
            if(0==select){
                System.out.println("没有事件发生");
                continue;
            }
            // 如果大于0 7 获取选择器事件集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                // 8 获取具体的事件key
                SelectionKey next = iterator.next();
                // 9 得到客户端链接通道，并将通道注册到选择器上，并指定监听事件为op_read
                if(next.isAcceptable()){
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("有客户端链接******");
                    // 此时的通道必须是非阻塞的，因为selector选择器通道需要轮询监听事件
                    socketChannel.configureBlocking(false);
                    // 指定监听事件为op_read
                    socketChannel.register(selector,SelectionKey.OP_READ);
                }
                // 10 读事件处理
                if(next.isReadable()){
                    // 对应的通道信息
                    SocketChannel socketChannel = (SocketChannel)next.channel();
                    ByteBuffer allocate = ByteBuffer.allocate(1024);
                    int read = socketChannel.read(allocate);
                    if(read>0){
                        String result=new String(allocate.array(),0,read, StandardCharsets.UTF_8);
                        System.out.println("客户端消息:"+result);
                        socketChannel.write(ByteBuffer.wrap("你好骚气啊".getBytes(StandardCharsets.UTF_8)));
                        socketChannel.close();
                    }
                }
                // 删除监听到的事件 防止重复操作
                iterator.remove();


            }
        }
    }
}
