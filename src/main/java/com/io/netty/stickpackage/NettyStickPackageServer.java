package com.io.netty.stickpackage;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.nio.charset.StandardCharsets;

/**
 * @version 1.0
 * @description: 粘包测试服务端
 * @author: sw
 * @date 2022-03-18
 */
public class NettyStickPackageServer {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup=new NioEventLoopGroup();
        EventLoopGroup workerGroup=new NioEventLoopGroup();
        ServerBootstrap serverBootstrap=new ServerBootstrap();
        serverBootstrap.group(bossGroup,workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG,128)
                .childOption(ChannelOption.SO_KEEPALIVE,true)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {

                        /**
                         * FixedLengthFrameDecoder 每个应用层数据包的都拆分成固定长度的大小
                         * 一般不用
                         * ch.pipeline().addLast(new FixedLengthFrameDecoder(20));
                         */
                        /**
                         * LineBasedFrameDecoder 每个应用层数据包，都以换行符作为分隔符，进行分割拆分
                         * 一般不用
                         * ch.pipeline().addLast(new LineBasedFrameDecoder(20));
                         */
                        ch.pipeline().addLast(new LineBasedFrameDecoder(2048));
                        /**
                         * 自定义换行符号
                         *  可以用
                         *  ByteBuf byteBuf=Unpooled.copiedBuffer("$".getBytes(StandardCharsets.UTF_8));
                         *  ch.pipeline().addLast(new DelimiterBasedFrameDecoder(2048,byteBuf));
                         */
                        /**
                         * 数据包长度
                         *  可以用内容长度
                         *    ch.pipeline().addLast(new LengthFieldBasedFrameDecoder())
                         */


                        ch.pipeline().addLast(new NettyServerStickPackageHandler());
                    }
                });
        ChannelFuture future = serverBootstrap.bind(9999);
        future.addListeners(new GenericFutureListener<Future<? super Void>>() {
            @Override
            public void operationComplete(Future<? super Void> future) throws Exception {
                if(future.isSuccess()){
                    System.out.println("绑定成功");
                }else{
                    System.out.println("绑定失败");
                }
            }
        });
        // 监听状态
        future.channel().closeFuture().sync();

    }
}
