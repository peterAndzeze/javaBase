package com.io.netty.chat;

import com.io.netty.twouse.NettyClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.Scanner;

/**
 * @version 1.0
 * @description: 聊天室客户端
 * @author: sw
 * @date 2022-03-15
 */
public class NettyChatClient {
    private String ip;
    private Integer port;

    public NettyChatClient(String ip, Integer port) {
        this.ip = ip;
        this.port = port;
    }

    public NettyChatClient() {

    }

    /**
     * 启动客户端
     */
    public void run() {
        NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup(2);
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(nioEventLoopGroup)
                .channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {

            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new StringDecoder());
                ch.pipeline().addLast(new StringEncoder());
                ch.pipeline().addLast(new NettyChatClientHandler());
            }
        });

        try {
            //7. 启动客户端,等待连接服务端,同时将异步改为同步
            ChannelFuture channelFuture = bootstrap.connect(ip, port).sync();
            Channel channel = channelFuture.channel();
            System.out.println("-------" + channel.localAddress().toString().substring(1) + "--------");
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String msg = scanner.nextLine();
                //向服务端发送消息
                channel.writeAndFlush(msg);
            }
            //8. 关闭通道和关闭连接池
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {

        } finally {
            nioEventLoopGroup.shutdownGracefully();
        }
    }

    public static void start(String ip, Integer port) {
        new NettyChatClient(ip, port).run();
    }



    public static void main(String[] args) {

        start("localhost", 9999);
    }
}
