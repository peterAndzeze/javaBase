package com.io.jdk;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @className: MultiplexerTimeServer
 * @description: 时间服务器
 * @author: sw
 * @date: 2021/10/9
 **/
public class MultiplexerTimeServer  implements Runnable{
    /**
     * 独立拥有selector 并把自己注册给selector
     */
    private Selector selector;
    /**
     * 服务端
     */
    private ServerSocketChannel serverSocketChannel;
    /**
     * 停止标识
     */
    private volatile boolean stop;

    /**
     * 构造函数 初始化
     * @param port
     */
    public MultiplexerTimeServer(int port) {
        try {
            selector=Selector.open();
            serverSocketChannel=ServerSocketChannel.open();
            /**
             * 设置非阻塞
             */
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1",port),1024);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("time server is start int port:"+port);
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop(){
        this.stop=true;
    }

    /**
     * 执行
     */
    @Override
    public void run() {
        while (!stop){
            try {
                //超时时间
                selector.select(10000);
                Set<SelectionKey> selectionKeys=selector.selectedKeys();
                Iterator<SelectionKey> it=selectionKeys.iterator();
                SelectionKey selectionKey=null;
                while (it.hasNext()){
                    selectionKey=it.next();
                    it.remove();
                    //处理
                    handleInput(selectionKey);
                }
            }catch (IOException e){

            }
        }
        if(selector!=null){
            try {
                selector.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey selectionKey) {
        try {
            if(selectionKey.isValid()){
                //接收请求
                if(selectionKey.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }
                //消息读取
                if(selectionKey.isReadable()){
                    SocketChannel socketChannel=(SocketChannel)selectionKey.channel();
                    ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
                    int readBytes=socketChannel.read(byteBuffer);
                    if(readBytes>0){
                        byteBuffer.flip();
                        byte[] bytes=new byte[byteBuffer.remaining()];
                        byteBuffer.get(bytes);
                        String body = new String(bytes);
                        System.out.println("this time server receive order:"+body);
                        //返回信息
                        doWrite(socketChannel,"服务端返回了");
                    }else if (readBytes<0){
                        selectionKey.channel();
                        socketChannel.close();
                    }

                }
            }
        }catch (IOException e){

        }finally {
            if(selectionKey!=null){
                selectionKey.cancel();
                if(selectionKey.channel()!=null){
                    try {
                        selectionKey.channel().close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    private void doWrite(SocketChannel socketChannel, String message) throws IOException {
        byte [] bytes=message.getBytes();
        ByteBuffer byteBuffer=ByteBuffer.allocate(message.length());
        byteBuffer.put(bytes);
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
    }
}
