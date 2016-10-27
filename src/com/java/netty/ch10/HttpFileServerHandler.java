package com.java.netty.ch10;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Pattern;



/**
 * Created by gongchunru on 2016/10/20.
 */
public class HttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    private final String url;

    public HttpFileServerHandler(String url) {
        this.url = url;
    }


    @Override
    protected void messageReceived(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        if (!request.getDecoderResult().isSuccess()){
            sendError(ctx,HttpResponseStatus.BAD_REQUEST);
            return;
        }
        if (request.getMethod()!=HttpMethod.GET){
            sendError(ctx,HttpResponseStatus.METHOD_NOT_ALLOWED);
            return;
        }
        final String uri = request.getUri();
        final String path = sanitizeUri(uri);

        if (path==null){
            sendError(ctx,HttpResponseStatus.FORBIDDEN);
            return;
        }

        File file = new File(path);
        if (file.isHidden()||!file.exists()){
            sendError(ctx,HttpResponseStatus.NOT_FOUND);
            return;
        }
        if (file.isDirectory()){
            if (uri.endsWith("/")){
                sendListing(ctx,file);
            }else {
                sendRedirect(ctx,uri+"/");
            }
            return;
        }

        if (!file.isFile()){
            sendError(ctx,HttpResponseStatus.FORBIDDEN);
            return;
        }
        RandomAccessFile randomAccessFile = null;

        try {
            randomAccessFile = new RandomAccessFile(file,"r");//以只读的方式打开
        } catch (FileNotFoundException e) {
            sendError(ctx,HttpResponseStatus.NOT_FOUND);
            return;
        }

        long fileLength = randomAccessFile.length();

        HttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,HttpResponseStatus.OK);
//        setContentLength();

        setContentTypeHeader(response,file);
//        if (is)
    }



    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        if (ctx.channel().isActive()) {

        }
    }

    public static final Pattern INSECURE_URI = Pattern.compile(".*[<>&\"].*");

    private static final Pattern ALLOWED_FILE_NAME = Pattern.compile("[A-Za-z0-9][-_A-Za-z0-9\\.]");

    private String sanitizeUri(String uri){
        try {
            uri = URLDecoder.decode(uri,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            try {
                uri = URLDecoder.decode(uri,"ISO-8859-1");
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
        }
        if (!uri.startsWith(url)) {
            return null;
        }
        if (!uri.startsWith("/")) {
            return null;
        }
        uri = uri.replace('/',File.separatorChar);

        if (uri.contains(File.separator+".")||uri.contains("."+File.separator)||uri.startsWith(".")
                || uri.endsWith(".")||INSECURE_URI.matcher(uri).matches()) {
            return null;
        }
        return System.getProperty("user.dir")+File.separator+uri;
    }


    private static void sendListing(ChannelHandlerContext ctx,File dir){

    }

    private static void sendRedirect(ChannelHandlerContext ctx,String newUrl){
//        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,)
    }

    private static void sendError(ChannelHandlerContext ctx, HttpResponseStatus status){
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,status, Unpooled.copiedBuffer("Failure: "+status+" \r\n", CharsetUtil.UTF_8));
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }

    private static void setContentTypeHeader(HttpResponse response, File file){
        MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
//        response.headers().set()
    }
}
