package com.io.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * @version 1.0
 * @description: 消息解码器
 * @author: sw
 * @date 2022-03-15
 */
public class MessageDecoder extends MessageToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, Object msg, List out) throws Exception {
        System.out.println("正在进行消息解码*******");
        // 传递数据到下一个handler
        ByteBuf byteBuf=(ByteBuf)msg;
        out.add(byteBuf.toString(CharsetUtil.UTF_8));
    }
}
