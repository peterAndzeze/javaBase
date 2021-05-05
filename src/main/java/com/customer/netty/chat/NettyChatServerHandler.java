package com.customer.netty.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * 聊天室服务端业务处理类
 */
public class NettyChatServerHandler extends SimpleChannelInboundHandler {
    /**
     * 定义在线客户端 channel
     */
    private static List<Channel> ONLINE_CHANNELS=new ArrayList<>();

    /**
     * 上线---》链接就绪 ONLINE_CHANNELS 中
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("["+channel.remoteAddress().toString().substring(1)+"] 上线");
        ONLINE_CHANNELS.add(channel);
    }

    /**
     * 下线
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("["+channel.remoteAddress().toString().substring(1)+"] 下线");
        ONLINE_CHANNELS.remove(channel);
    }

    /**
     * 客户端异常
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        Channel channel = ctx.channel();
        System.out.println("["+channel.remoteAddress().toString().substring(1)+"] 发生了异常");


    }

    /**
     * 读取消息
     * @param channelHandlerContext
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object msg) throws Exception {
        /**
         * 将接收到的消息发送给其它在线客户端
         */
        Channel channel = channelHandlerContext.channel();

        for (Channel ch:ONLINE_CHANNELS) {
            if(ch!=channel){
                //System.out.println("不等于");
                ch.writeAndFlush("["+channel.remoteAddress().toString().substring(1)+"] 说："+msg);
            }
        }

    }
}
