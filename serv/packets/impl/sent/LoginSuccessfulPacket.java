package serv.packets.impl.sent;

import org.jboss.netty.channel.Channel;
import serv.obj.Client;
import serv.packets.Packet;
import serv.util.ServerTools;

import java.io.IOException;

public class LoginSuccessfulPacket extends SPacket {

    public LoginSuccessfulPacket(Channel connection){
        this.connection = connection;
    }
    @Override
    public void send_packet() {

            Client user = ServerTools.getClientByChannel(this.connection);
            if(user != null) { //if we find the user obj, lets inform the client connec
                //write packet number
                writer.writeByte(2);

                //write info to buffer
                writer.writeInt(user.getUsername().getBytes().length);
                writer.writeBytes(user.getUsername().getBytes());

                writer.writeInt(user.getPassword().getBytes().length);
                writer.writeBytes(user.getPassword().getBytes());

                writer.writeInt(user.getFirst_name().getBytes().length);
                writer.writeBytes(user.getFirst_name().getBytes());

                writer.writeInt(user.getLast_name().getBytes().length);
                writer.writeBytes(user.getLast_name().getBytes());

                writer.writeInt(user.getEmail().getBytes().length);
                writer.writeBytes(user.getEmail().getBytes());

                writer.writeInt(user.getPhone_number().getBytes().length);
                writer.writeBytes(user.getPhone_number().getBytes());

                //Finally send out buffer
                connection.write(writer);
            } else {
                System.err.println("There was an error handling a client login on channel: " + this.connection);
            }

    }
}
