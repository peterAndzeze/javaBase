package com.io.netty.chat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @version 1.0
 * @description: 客户端处理事件
 * @author: sw
 * @date 2022-03-15
 */
public class NettyChatClientHandler extends SimpleChannelInboundHandler<String> {

    /**
     * 通道读取就绪事件
     * @param ctx 上线文
     * @param msg 消息
     * @throws Exception 异常
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        String remote = ctx.channel().remoteAddress().toString().substring(1);
        System.out.println("["+remote+"]"+"说:"+msg);
    }

    /**
     * 链接上
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("通道链接上了");
    }

    /**
     * 链接上服务端
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("链接服务:"+ctx.channel());
    }

    /**
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
       cause.printStackTrace();
        System.out.println("通道异常:"+cause.getMessage());
    }
}
