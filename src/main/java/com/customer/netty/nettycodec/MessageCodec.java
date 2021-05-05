package com.customer.netty.nettycodec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import io.netty.util.CharsetUtil;

import java.util.List;


/**
 * 消息解码器
 */
public class MessageCodec extends MessageToMessageCodec {

    /**
     * 解码器
     * @param channelHandlerContext
     * @param msg
     * @param out
     * @throws Exception
     */
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, Object msg, List out) throws Exception {
        System.out.println("正在进行消息解码**");
        ByteBuf byteBuf=(ByteBuf)msg;
        out.add(byteBuf.toString(CharsetUtil.UTF_8));//传递到下一个handler
    }

    /**
     * 编码器
     * @param channelHandlerContext
     * @param o
     * @param list
     * @throws Exception
     */
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, List list) throws Exception {
        System.out.println("消息正在进行编码*******");
        String str=(String) o;
        list.add(Unpooled.copiedBuffer(str, CharsetUtil.UTF_8));
    }
}
