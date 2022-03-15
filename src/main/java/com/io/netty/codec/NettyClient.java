package com.io.netty.codec;

import com.customer.netty.nettycodec.MessageDecoder;
import com.customer.netty.nettycodec.MessageEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @version 1.0
 * @description: 客户端
 * @author: sw
 * @date 2022-03-12
 */
public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
       //1. 创建线程组
        EventLoopGroup eventLoopGroup=new NioEventLoopGroup();
       //2. 创建客户端启动助手
        Bootstrap bootstrap=new Bootstrap();
       //3. 设置线程组
        bootstrap.group(eventLoopGroup)
                //4. 设置客户端通道实现为NIO
                .channel(NioSocketChannel.class)
                //5. 创建一个通道初始化对象
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                       /* // 添加解码器
                        ch.pipeline().addLast("messageDecoder",new MessageDecoder());
                        // 添加消息出栈编码器
                        ch.pipeline().addLast("messageEncoder",new MessageEncoder());*/
                        // 编码和解码统一
                        ch.pipeline().addLast("messageCodec",new MessageCodec());
                        //6. 向pipeline中添加自定义业务处理handler
                        ch.pipeline().addLast(new NettyClientHandler());
                    }
                });

       //7. 启动客户端,等待连接服务端,同时将异步改为同步
        ChannelFuture channelFuture = bootstrap.connect("localhost", 9999).sync();
        //8. 关闭通道和关闭连接池 不是实际意义的关闭 而是监听关闭的状态
        channelFuture.channel().closeFuture().sync();
        eventLoopGroup.shutdownGracefully();
    }
}
