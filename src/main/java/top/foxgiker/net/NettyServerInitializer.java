package top.foxgiker.net;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;

public class NettyServerInitializer extends ChannelInitializer<SocketChannel> {
    /**
     * 当连接被注册到Channel后，立刻执行此方法
     * @param socketChannel
     * @throws Exception
     */
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast("encoder", new ProtobufEncoder()); // protobuf 编码器
        // 需要指定要对哪种对象进行解码
        pipeline.addLast("decoder", new ProtobufDecoder(UserModel.User.getDefaultInstance()));
        pipeline.addLast(new GameNettyServerHandler());
    }
}
