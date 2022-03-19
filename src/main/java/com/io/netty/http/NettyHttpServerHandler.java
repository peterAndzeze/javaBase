package com.io.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.CharsetUtil;

/**
 * @version 1.0
 * @description: http 链接
 * @author: sw
 * @date 2022-03-16
 */
public class NettyHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {
    /**
     * 读取就绪事件
     * @param ctx 上线文
     * @param msg 消息
     * @throws Exception 异常
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        // 判断请求 是否是http 请求
        if (msg instanceof HttpRequest){
            DefaultHttpRequest request= (DefaultHttpRequest) msg;
            System.out.println("浏览器请求路径:"+request.uri());
            // 写出信息
            ByteBuf byteBuf= Unpooled.copiedBuffer("hello ", CharsetUtil.UTF_8);
            DefaultHttpResponse response=new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,byteBuf);
            // 设置响应头
            response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/html;charset=utf-8")
                    .set(HttpHeaderNames.CONTENT_LENGTH,byteBuf.readableBytes());
            ctx.writeAndFlush(response);

        }
    }
}
