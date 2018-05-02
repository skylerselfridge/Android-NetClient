package serv.packets.impl.sent;

import org.jboss.netty.channel.Channel;

import java.io.IOException;

public class RegistrationSuccessPacket extends SPacket {
    public RegistrationSuccessPacket(Channel connection){
        this.connection = connection;
    }
    @Override
    public void send_packet() {

            //write packet number
            writer.writeByte(4);

            connection.write(writer);

    }
}
