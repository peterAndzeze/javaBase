package com.io.netty.stickpackage;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelPromise;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * @version 1.0
 * @description: TODO
 * @author: sw
 * @date 2022-03-18
 */
public class NettyClientStickPackageHandler implements ChannelInboundHandler {
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String msg="hello stickPackage";
        System.out.println(msg.getBytes().length);
        for(int i=0;i<10;i++){
            //ctx.writeAndFlush(Unpooled.copiedBuffer(msg+i,CharsetUtil.UTF_8));
            /**
             *    换行符号
             *    ctx.writeAndFlush(Unpooled.copiedBuffer(msg+i+"\n",CharsetUtil.UTF_8));
             */
            ctx.writeAndFlush(Unpooled.copiedBuffer(msg+i+"\n",CharsetUtil.UTF_8));
            /**
             * 自定义
             */
            //ctx.writeAndFlush(Unpooled.copiedBuffer(msg+i+"$",CharsetUtil.UTF_8));
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf=(ByteBuf)msg;
        System.out.println("服务端回复消息:"+byteBuf.toString(CharsetUtil.UTF_8));
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
