package com.customer.netty.chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * 聊天室客户端
 */
public class NettyChatClient {
    private String ip;
    private int port;

    public NettyChatClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    /**
     * 客户端启动
     */
    public void run() throws InterruptedException {
        EventLoopGroup eventLoopGroup=new NioEventLoopGroup();
        Bootstrap bootstrap=new Bootstrap();
        bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new StringEncoder());
                socketChannel.pipeline().addLast(new StringDecoder());
                socketChannel.pipeline().addLast(new NettyChatClientHandler());
            }
        });

        ChannelFuture channelFuture = bootstrap.connect(ip, port).sync();
        System.out.println("客户端启动完成");
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextLine()){
            String next = scanner.next();
            channelFuture.channel().writeAndFlush(next);
        }
        channelFuture.channel().closeFuture().sync();
        eventLoopGroup.shutdownGracefully();
    }

    public static void main(String[] args) throws InterruptedException {
        new NettyChatClient("localhost",9998).run();
    }


}
