package com.io.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * @version 1.0
 * @description: 消息编解码
 * @author: sw
 * @date 2022-03-15
 */
public class MessageCodec extends MessageToMessageCodec {
    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, List out) throws Exception {
        System.out.println("编码******");
        String str=(String)msg;
        out.add(Unpooled.copiedBuffer(str, CharsetUtil.UTF_8));
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, Object msg, List out) throws Exception {
        System.out.println("解码******");
        ByteBuf byteBuf=(ByteBuf)msg;
        out.add(byteBuf.toString(CharsetUtil.UTF_8));
    }
}
