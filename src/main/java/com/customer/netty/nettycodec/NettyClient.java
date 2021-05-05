package com.customer.netty.nettycodec;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * netty 客户端
 */
public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
                //1、创建线程组
        EventLoopGroup eventLoopGroup=new NioEventLoopGroup();

                //2、设置客户端启动助手
        Bootstrap bootstrap=new Bootstrap();

                //3、设置线程组
        bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                //4、设置客户端通道实现为NIO
        .handler(new ChannelInitializer<SocketChannel>() {//5、创建一个通道初始化对象
            @Override
            protected void initChannel(SocketChannel channel) throws Exception {
              /*  //添加解码器
                channel.pipeline().addLast("消息转码器",new MessageDecoder());
                //添加编码器
                channel.pipeline().addLast("消息编码器",new MessageEncoder());*/
                channel.pipeline().addLast("消息编解码",new MessageCodec());
                //自定义处理器
                channel.pipeline().addLast(new NettyClientHandler());
            }
        });

                //6、向pipeline中添加自定义业务处理handler

                //7、启动客户端，等待链接服务端，同时将异步改为同步
        ChannelFuture channelFuture = bootstrap.connect("localhost", 9999).sync();
        //ChannelFuture channelFuture = bootstrap.connect("localhost", 9999);

        //8、关闭通道和关闭链接池
        channelFuture.channel().closeFuture().sync();
        eventLoopGroup.shutdownGracefully();
    }
}
