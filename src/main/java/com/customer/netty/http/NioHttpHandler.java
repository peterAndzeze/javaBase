package com.customer.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.EventExecutorGroup;

public class NioHttpHandler extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpObject httpObject) throws Exception {
        System.out.println(httpObject.decoderResult());
            if(httpObject instanceof HttpRequest){
                DefaultHttpRequest request=(DefaultHttpRequest) httpObject;

                String uri = request.uri();
                System.out.println(uri);
                Channel channel = channelHandlerContext.channel();
                ByteBuf byteBuf= Unpooled.copiedBuffer("nett http server return success", CharsetUtil.UTF_8);
                DefaultFullHttpResponse respons= new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,byteBuf);
                /**
                 * 设置响应头
                 */
                respons.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/html;charset=utf-8");
                respons.headers().set(HttpHeaderNames.CONTENT_LENGTH,byteBuf.readableBytes());
                if(!"/favicon.ico".equals(uri)){
                    /**
                     * 出栈
                     */
                    channel.writeAndFlush(respons);
                }

            }
    }
}
