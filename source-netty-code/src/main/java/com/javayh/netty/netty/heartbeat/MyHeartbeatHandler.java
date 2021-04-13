package com.javayh.netty.netty.heartbeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-04-10
 */
public class MyHeartbeatHandler extends ChannelInboundHandlerAdapter {

    /**
     *
     * @param ctx   上下文
     * @param evt   时间
     * @throws Exception
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

        if(evt instanceof IdleStateEvent){
            String msg = null;
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            switch (idleStateEvent.state()){
                case READER_IDLE :
                    msg = "READER_IDLE";
                    break;
                case WRITER_IDLE :
                    msg=  "WRITER_IDLE";
                    break;
                case ALL_IDLE :
                    msg=  "ALL_IDLE";
                    break;
                default: break;
            }
            System.out.println(ctx.channel().remoteAddress() + "超时" + msg);
            ctx.channel().closeFuture().sync();
        }

    }
}
