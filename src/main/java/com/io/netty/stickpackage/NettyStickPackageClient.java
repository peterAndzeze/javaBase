package com.io.netty.stickpackage;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;

import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

/**
 * @version 1.0
 * @description: 粘包客户端
 * @author: sw
 * @date 2022-03-18
 */
public class NettyStickPackageClient {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup eventLoopGroup=new NioEventLoopGroup();

        Bootstrap bootstrap=new Bootstrap();
        bootstrap.group(eventLoopGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new LineBasedFrameDecoder(2048));
                        ch.pipeline().addLast(new NettyClientStickPackageHandler());
                    }
                });
        ChannelFuture channelFuture = bootstrap.connect(new InetSocketAddress("localhost", 9999)).sync();
        channelFuture.channel().closeFuture().sync();
        eventLoopGroup.shutdownGracefully();
    }
}
