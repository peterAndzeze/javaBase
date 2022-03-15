package com.io.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @version 1.0
 * @description: 自定义客户端处理器
 * @author: sw
 * @date 2022-03-12
 */
public class NettyClientHandler implements ChannelInboundHandler {
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {

    }
    /***
     * 通道就绪事件
     * @param ctx 上线文
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 消息内容直接是String 交给编码器统一进行编码
        ChannelFuture channelFuture = ctx.writeAndFlush("my is client");
        channelFuture.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if(future.isSuccess()){
                    System.out.println("数据发送成功");
                }else{
                    System.out.println("数据发送失败");
                }
            }
        });
    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

    }

    /**
     * 通道读取事件
     * @param ctx 通道上线文
     * @param msg 客户端发送的
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 数据已经被转码 所以 直接使用
        System.out.println("服务端发送过来的消息:"+ msg);

    }

    /**
     * 通道读取完毕事件
     * @param ctx 上线文
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //ctx.writeAndFlush(Unpooled.copiedBuffer("haha haha ",CharsetUtil.UTF_8));
    }

    /**
     * 通道异常事件
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
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


}
