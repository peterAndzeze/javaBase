package com.io.netty.unpackage;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.internal.ChannelUtils;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.Arrays;

/**
 * @version 1.0
 * @description: TODO
 * @author: sw
 * @date 2022-03-19
 */
public class NettyUnPackageClientHandler implements ChannelInboundHandler {
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        char[] chars = new char[102400];
        Arrays.fill(chars, 0, 102398, 'a');
        chars[102399]='\n';
        ctx.writeAndFlush(Unpooled.copiedBuffer(chars,CharsetUtil.UTF_8));

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf=(ByteBuf) msg;
        System.out.println("服务端返回:"+byteBuf.toString(CharsetUtil.UTF_8));
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
