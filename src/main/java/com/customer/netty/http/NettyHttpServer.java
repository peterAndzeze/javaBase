package com.customer.netty.http;

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
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * netty http 请求处理
 */
public class NettyHttpServer {

    private int port;

    public NettyHttpServer(int port) {
        this.port = port;
    }
    public void run() throws InterruptedException {
        EventLoopGroup boosGroup=null;
        EventLoopGroup workGroup=null;
        try{
            boosGroup=new NioEventLoopGroup(1);
            workGroup=new NioEventLoopGroup(2);
            ServerBootstrap serverBootstrap=new ServerBootstrap();
            serverBootstrap.group(boosGroup,workGroup).channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,128)
                    .childOption(ChannelOption.SO_KEEPALIVE,Boolean.TRUE)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new HttpServerCodec());

                            socketChannel.pipeline().addLast(new NioHttpHandler());
                        }
                    });
            ChannelFuture channelFuture = serverBootstrap.bind(port);
            channelFuture.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    boolean success = channelFuture.isSuccess();
                    if(success){
                        System.out.println("http 端口绑定成功");
                    }
                }
            });
            System.out.println("http server 启动成功");

            channelFuture.channel().closeFuture().sync();
        }finally {
            boosGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new NettyHttpServer(8080).run();
    }


}
