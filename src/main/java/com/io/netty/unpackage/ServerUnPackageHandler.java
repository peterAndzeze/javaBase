package com.io.netty.unpackage;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * @version 1.0
 * @description: TODO
 * @author: sw
 * @date 2022-03-19
 */
public class ServerUnPackageHandler implements ChannelInboundHandler {
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

    }
    public int count=0;
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf=(ByteBuf) msg;
        System.out.println("接收内容:"+byteBuf.toString().length());
        System.out.println("接收次数:"+(++count));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

    }
}
