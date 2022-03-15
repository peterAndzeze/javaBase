package com.io.netty.twouse;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @version 1.0
 * @description: 服务端 异步
 * @author: sw
 * @date 2022-03-10
 */
public class NettyServerSyncClient {
    public static void main(String[] args) throws InterruptedException {
        //1. 创建bossGroup线程组: 处理网络事件--连接事件
        // 默认线程个数是处理器个数*2 一般情况下，bossGroup组一个线程就可以了，看实际场景需要
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        //2. 创建workerGroup线程组: 处理网络事件--读写事件 处理器个数*2
        EventLoopGroup workGroup = new NioEventLoopGroup();
        //3. 创建服务端启动助手
        ServerBootstrap serverBootstrap=new ServerBootstrap();
        //4. 设置bossGroup线程组和workerGroup线程组
        serverBootstrap.group(bossGroup,workGroup)
                //5. 设置服务端通道实现为NIO
                .channel(NioServerSocketChannel.class)
                // 6. 参数设置 队列等待大小
                .option(ChannelOption.SO_BACKLOG,128)
                // 参数设置，检测链接是否活跃 workGroup
                .childOption(ChannelOption.SO_KEEPALIVE,true)
                //7. 创建一个通道初始化对象 workGroup
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        //8. 向pipeline中添加自定义业务处理handler
                        ch.pipeline().addLast(new NettyServerHandler() );
                    }
                });

        //9. 启动服务端并绑定端口,同时将异步改为同步
        ChannelFuture future = serverBootstrap.bind(9999);
        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if(future.isSuccess()){
                    System.out.println("端口绑定成功");
                }else{
                    System.out.println("端口绑定失败");
                }
            }
        });
        System.out.println("服务端启动成功**********");
        //10. 关闭通道和关闭连接池 不是真正意义上的关闭，而是监听通道关闭的状态，，和连接池的关闭
        future.channel().closeFuture().sync();
        bossGroup.shutdownGracefully();
        workGroup.shutdownGracefully();
    }
}