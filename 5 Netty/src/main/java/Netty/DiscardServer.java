package Netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.SocketAddress;


/**
 * 第一个Netty应用
 */
public class DiscardServer {
    private int port;

    public DiscardServer(int port) {
        this.port = port;
    }

    public void runServer() throws InterruptedException {
        EventLoopGroup boss = new NioEventLoopGroup(3);
        EventLoopGroup worker = new NioEventLoopGroup(4);
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(boss, worker)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new InServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128); // TCP参数，表示服务器接受连接的队列长度，如果队列满了，客户端连接会拒绝。 windows 200 其他 128
            ChannelFuture f = b.bind(port).sync();
            f.channel().closeFuture().sync();
        } finally {
            worker.shutdownGracefully();
            boss.shutdownGracefully();
        }
    }
}

/**
 * 初始化一个Handler处理器
 * <p>
 * 用于处理将收到的信息返回
 */
class InServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("开始读取");
        ctx.writeAndFlush(msg);
        Thread.sleep(5000);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        SocketAddress clientinfo = ctx.channel().remoteAddress();
        System.out.println("InServerHandler 被激活");
        System.out.println(clientinfo);
    }
}