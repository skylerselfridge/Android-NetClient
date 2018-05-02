package client.packets.impl.sent;

//base class for sent packets

import org.jboss.netty.buffer.ChannelBuffer;

import org.jboss.netty.buffer.ChannelBuffers;

import java.io.BufferedOutputStream;

public abstract class SPacket {

    ChannelBuffer writer = ChannelBuffers.dynamicBuffer();

    public abstract void send_packet();

}
