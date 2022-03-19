package com.io.netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @version 1.0
 * @description: http
 * @author: sw
 * @date 2022-03-15
 */
public class NettyHttpServer {
    private int port;

    public NettyHttpServer() {
    }

    public NettyHttpServer(int port) {
        this.port = port;
    }

    public void run(){
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
                        //添加内置的http编解码器
                        ch.pipeline().addLast(new HttpServerCodec());
                        //TODO 自己的业务逻辑
                        ch.pipeline().addLast(new NettyHttpServerHandler() );
                    }
                });

        //9. 启动服务端并绑定端口,同时将异步改为同步
        ChannelFuture future = serverBootstrap.bind(port);
        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if(future.isSuccess()){
                    System.out.println("http端口绑定成功");
                }else{
                    System.out.println("http端口绑定失败");
                }
            }
        });
        System.out.println("http服务端启动成功**********");
        //10. 关闭通道和关闭连接池 不是真正意义上的关闭，而是监听通道关闭的状态，，和连接池的关闭
        try {
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    /**
     * 启动函数
     * @param port
     */
    public static void start(int port){
        new NettyHttpServer(port).run();
    }

    public static void main(String[] args) {
        start(8080);
    }


}
