package client.packets.impl.received;

import client.packets.Packet;
import client.packets.PacketHandler;
import org.jboss.netty.buffer.ChannelBuffer;


import java.io.IOException;

public class ServerConnectionHandler implements PacketHandler {


    @Override
    public void handle(Packet p, ChannelBuffer buf) {

        System.out.println("Successfully connected to the server.");


    }
}
