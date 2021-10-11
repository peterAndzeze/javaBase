package com.io.jdk;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @className: TImeClientHandler
 * @description: TODO 类描述
 * @author: sw
 * @date: 2021/10/9
 **/
public class TimeClientHandler implements Runnable{
    private String host;
    private int port;
    private Selector selector;
    private SocketChannel socketChannel;
    private volatile  boolean stop;

    public TimeClientHandler(String host, int port) {
        this.host = null==host?"127.0.0.1":host;
        this.port = port;
        try {
            selector=Selector.open();
            socketChannel=SocketChannel.open();
            socketChannel.configureBlocking(false);
        }catch (IOException e){

        }
    }

    @Override
    public void run() {
        //判断连接
        try {
            doConnection(socketChannel,selector);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (!stop){
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeys=selector.selectedKeys();
                Iterator<SelectionKey> iterator=selectionKeys.iterator();
                SelectionKey key=null;
                while (iterator.hasNext()){
                    key=iterator.next();
                    iterator.remove();
                    handleInput(key);
                }
            }catch (IOException e){

            }
        }
        if(selector!=null){
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey selectionKey) {
        try {
            if(selectionKey.isValid()){
                SocketChannel socketChannel =(SocketChannel) selectionKey.channel();
                if(socketChannel.isConnected()){
                    if(socketChannel.finishConnect()){
                        socketChannel.register(selector, SelectionKey.OP_READ);
                        doWrite(socketChannel);
                    }
                }

                //消息读取
                if(selectionKey.isReadable()){
                    ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
                    int readBytes=socketChannel.read(byteBuffer);
                    if(readBytes>0){
                        byteBuffer.flip();
                        byte[] bytes=new byte[byteBuffer.remaining()];
                        byteBuffer.get(bytes);
                        String body = new String(bytes);
                        System.out.println("this time server call back order:"+body);
                        //返回信息
                        this.stop=true;
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

    private void doConnection(SocketChannel socketChannel, Selector selector) throws IOException {
        if(socketChannel.connect(new InetSocketAddress(host,port))){
            socketChannel.register(selector, SelectionKey.OP_READ);
            doWrite(socketChannel);
        }else {
            socketChannel.register(selector,SelectionKey.OP_CONNECT);
        }
    }

    private void doWrite(SocketChannel socketChannel) throws IOException {
        byte [] req="客户端请求".getBytes(StandardCharsets.UTF_8);
        ByteBuffer byteBuffer=ByteBuffer.allocate(req.length);
        byteBuffer.put(req);
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
        if(!byteBuffer.hasRemaining()){
            System.out.println("client send order success");
        }
    }
}
