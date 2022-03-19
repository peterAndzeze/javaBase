package com.io.netty.http;

import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @description: 自定义客户端处理器
 * @author: sw
 * @date 2022-03-12
 */
public class NettyHttpClientHandler extends SimpleChannelInboundHandler<HttpObject> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        if(msg instanceof FullHttpResponse){
            FullHttpResponse response = (FullHttpResponse)msg;
            ByteBuf buf = response.content();
            String result = buf.toString(CharsetUtil.UTF_8);
            System.out.println("response -> "+result);
        }

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String url="http://localhost:8080/test/hello";
        UserForm userForm=new UserForm();
        userForm.setAge(1);
        userForm.setUserName("张三");
        userForm.setUserId(11L);
        String msg = JSON.toJSONString(userForm);
        //配置HttpRequest的请求数据和一些配置信息

        HttpRequest request = buildRequest(msg,url,true);
        ChannelFuture channelFuture = ctx.writeAndFlush(request);
        channelFuture.addListeners(new GenericFutureListener<Future<? super Void>>() {
            @Override
            public void operationComplete(Future<? super Void> future) throws Exception {
                System.out.println("发送结果:"+future.isSuccess());
            }
        });
    }
    public  HttpRequest buildRequest(String msg, String url, boolean isKeepAlive) throws Exception {
        URL netUrl = new URL(url);
        URI uri = new URI(netUrl.getPath());
        //构建http请求
        ByteBuf byteBuf = Unpooled.wrappedBuffer(msg.getBytes(StandardCharsets.UTF_8));
        DefaultHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1,
                HttpMethod.POST,
                uri.toASCIIString(),
                byteBuf);

        //设置请求的host(这里可以是ip,也可以是域名)
        request.headers().set(HttpHeaderNames.HOST, netUrl.getHost())
                .set(HttpHeaderNames.CONTENT_TYPE,"application/json");
        //发送的长度
        request.headers().set(HttpHeaderNames.CONTENT_LENGTH, byteBuf.readableBytes());
        //是否是长连接
        if (isKeepAlive){
            request.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
        }

        return request;
    }
}
