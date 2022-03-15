package com.io.netty.codec;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * @version 1.0
 * @description: 消息编码器
 * @author: sw
 * @date 2022-03-15
 */
public class MessageEncoder extends MessageToMessageEncoder {
    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, List out) throws Exception {
        System.out.println("消息正在编码********");
        String str=(String)msg;
        // 传递给下一个handler
        out.add(Unpooled.copiedBuffer(str, CharsetUtil.UTF_8));
    }
}
