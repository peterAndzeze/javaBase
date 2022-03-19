package com.io.netty.http;

import com.alibaba.fastjson.serializer.StringCodec;
import com.io.netty.twouse.NettyClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

import java.net.InetSocketAddress;

/**
 * @version 1.0
 * @description: netty 做http的客户端
 * @author: sw
 * @date 2022-03-16
 */
public class NettyHttpClient {



    public static void main(String[] args) {
        // 一个主
        NioEventLoopGroup bossGroup=new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup=new NioEventLoopGroup();
        Bootstrap bootstrap=new Bootstrap();
        bootstrap.group(workerGroup)
                //5. 设置服务端通道实现为NIO
                .channel(NioSocketChannel.class)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000)
                .option(ChannelOption.TCP_NODELAY,true)
                //长连接
                .option(ChannelOption.SO_KEEPALIVE,true)
                .handler(new LoggingHandler(LogLevel.DEBUG))
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                     /*   ch.pipeline().addLast("http-encoder", new HttpResponseEncoder());
                        ch.pipeline().addLast("http-decoder", new HttpRequestDecoder());*/
                        ch.pipeline().addLast(new HttpClientCodec());
                        ch.pipeline().addLast("http-aggregator", new HttpObjectAggregator(65536));
                        ch.pipeline().addLast(new NettyHttpClientHandler());
                    }
                });
        try {
            ChannelFuture channelFuture = bootstrap.connect(new InetSocketAddress("localhost", 8080)).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {


        }finally {
            bossGroup.shutdownGracefully();
        }


    }

}
