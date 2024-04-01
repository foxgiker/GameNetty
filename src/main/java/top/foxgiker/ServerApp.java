package top.foxgiker;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class ServerApp {

    private static void startGameNettyServer(){
        /**
         * EventLoopGroup：事件循环组，是一个线程池，也是一个死循环，用于不断地接收用户请求
         * bossGroup： 用户监听及建立连接，并把每一个连接抽象为一个channel，最后再将连接交给workGroup处理；
         * workGroup: 真正的处理连接
         */

        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();


        // 服务端启动时的初始化操作
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup,workGroup).channel(NioServerSocketChannel.class)


    }

    public static void main(String[] args){
        startGameNettyServer();
    }
}
