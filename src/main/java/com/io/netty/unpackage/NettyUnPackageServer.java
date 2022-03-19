package com.io.netty.unpackage;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;

/**
 * @version 1.0
 * @description: 拆包服务
 * @author: sw
 * @date 2022-03-19
 */
public class NettyUnPackageServer {
    public static void main(String[] args) throws InterruptedException {
        ServerBootstrap serverBootstrap=new ServerBootstrap();
        EventLoopGroup bossGroup=new NioEventLoopGroup(1);
        EventLoopGroup workerGroup=new NioEventLoopGroup();
        serverBootstrap.group(bossGroup,workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG,128)
                .childOption(ChannelOption.SO_KEEPALIVE,true)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        //防止拆包 配置解码器，4种 选其一  长度 必须和客户端保持一致
                        ch.pipeline().addLast(new LineBasedFrameDecoder(102400));
                        ch.pipeline().addLast(new ServerUnPackageHandler());
                    }
                });
        ChannelFuture channelFuture = serverBootstrap.bind(9999).sync();
        channelFuture.addListeners(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if(future.isSuccess()){
                    System.out.println("监听端口成功");
                }else{
                    System.out.println("监听端口失败");
                }
            }
        });
        System.out.println("拆包服务端启动成功");
        channelFuture.channel().closeFuture().sync();
    }
}
