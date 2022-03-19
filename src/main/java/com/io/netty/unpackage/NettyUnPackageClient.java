package com.io.netty.unpackage;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @version 1.0
 * @description: 拆包客户端
 * @author: sw
 * @date 2022-03-19
 */
public class NettyUnPackageClient {
    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap=new Bootstrap();
        EventLoopGroup eventLoopGroup=new NioEventLoopGroup();
        ChannelFuture channelFuture = bootstrap.group(eventLoopGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new NettyUnPackageClientHandler());
                    }
                }).connect(new InetSocketAddress("localhost", 9999))
                .sync();
        System.out.println("拆包客户端启动成功");
        channelFuture.channel().closeFuture().sync();

    }
}
