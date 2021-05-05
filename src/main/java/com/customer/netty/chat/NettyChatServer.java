package com.customer.netty.chat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * 聊天室启动类
 */
public class NettyChatServer {
    /**
     * 端口号
     */
    private int port;

    public NettyChatServer(int port) {
        this.port = port;
    }

    /**
     * 启动聊天室函数
     */
    public void run() throws InterruptedException {
        // 1 服务端启动
        EventLoopGroup boosGroup=null;
        EventLoopGroup workGroup=null;
        ChannelFuture channelFuture=null;
        try {
            boosGroup=new NioEventLoopGroup(1);
            workGroup=new NioEventLoopGroup(2*8);
            ServerBootstrap serverBootstrap=new ServerBootstrap();
            serverBootstrap.group(boosGroup,workGroup).channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,128)
                    .childOption(ChannelOption.SO_KEEPALIVE,Boolean.TRUE)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new StringEncoder());
                            socketChannel.pipeline().addLast(new StringDecoder());
                            socketChannel.pipeline().addLast(new NettyChatServerHandler());
                        }
                    });
            channelFuture = serverBootstrap.bind(port).sync();
            channelFuture.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if(channelFuture.isSuccess()){
                        System.out.println("聊天室端口绑定完成");
                    }else {
                        System.out.println("聊天室端口绑定失败");
                    }
                }
            });
            System.out.println("聊天室客户端启动完成");
            channelFuture.channel().closeFuture().sync();
        }finally {
            boosGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new NettyChatServer(9998).run();
    }

}
