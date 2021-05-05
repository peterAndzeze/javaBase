package com.customer.netty.simple;

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
 * netty f服务端
 */
public class NettyServer {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 创建boosGroup线程组：处理网络事件---链接事件
         */

        EventLoopGroup bossGroup=new NioEventLoopGroup(1);
        //2.创建workerGroup 线程组：处理网络事件---读写事件 2*处理器线程数
        EventLoopGroup workGroup=new NioEventLoopGroup(2*8);
        //3 创建服务端启动助手
        ServerBootstrap serverBootstrap=new ServerBootstrap();
        //4 设置bossGroup 和workGroup
        serverBootstrap.group(bossGroup,workGroup).channel(NioServerSocketChannel.class)
                //option 设置的是boosGroup
                .option(ChannelOption.SO_BACKLOG,128)
                //childOption 设置的是workGroup
                .childOption(ChannelOption.SO_KEEPALIVE,Boolean.TRUE)//设置参数
                // 7 创建一个通道初始化对象
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel channel) throws Exception {
                        // 8 向 pipeline 中添加自定义业务处理handler

                        channel.pipeline().addLast(new NettyServerHandler());

                    }
                });

                // 9 启动服务端并绑定端口，同时将异步改为同步
        //ChannelFuture sync = serverBootstrap.bind(9999).sync();
        ChannelFuture sync = serverBootstrap.bind(9999);
        sync.addListener(new ChannelFutureListener(){
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                boolean success = channelFuture.isSuccess();
                if(success){
                    System.out.println("端口绑定成功");
                }else {
                    System.out.println("端口绑定失败");
                }

            }
        });

        System.out.println("服务端启动成功");
        // 10 关闭通道(并不是真正意义上的关闭，而是监听通道关闭的状态)和关闭链接池
        sync.channel().closeFuture().sync();
        System.out.println("服务端关闭");

        bossGroup.shutdownGracefully();
        workGroup.shutdownGracefully();

    }
}
