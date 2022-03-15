package com.io.netty.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @description: 服务端handler  数据类型采用String
 * @author: sw
 * @date 2022-03-15
 */
public class NettyChatServerHandler extends SimpleChannelInboundHandler<String> {
    public static List<Channel> channels=new ArrayList<>();
    /**
     * 通道就绪事件
     * @param ctx 上线文
     * @throws Exception 异常
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        /**
         * 有新的客户端链接的时候 当如集合
         */
        Channel channel = ctx.channel();
        channels.add(channel);
        System.out.println("server :"+channel.remoteAddress().toString().substring(1)+"在线");
    }

    /**
     * 通道未就绪 channel 下线
     * @param ctx 上下文
     * @throws Exception 异常
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channels.remove(channel);
        System.out.println("客户端下线了:"+channel.remoteAddress().toString().substring(1));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        System.out.println(ctx.channel().remoteAddress().toString().substring(1)+" 异常了.");
    }

    /**
     * 通道读事件
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        //当前通道
        Channel channel = ctx.channel();
        for(Channel c:channels){
            if(c!=channel){
                c.writeAndFlush("["+channel.remoteAddress().toString().substring(1)+"] 说:"+msg);
            }
        }
    }
}
