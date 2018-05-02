package serv.packets.impl.sent;

import org.jboss.netty.channel.Channel;
import serv.obj.Client;
import serv.util.ServerTools;

import java.io.IOException;

public class UserUpdateSuccessfulPacket extends SPacket {
    public UserUpdateSuccessfulPacket(Channel connection){
        this.connection = connection;
    }
    @Override
    public void send_packet() {
        //user
        Client user = ServerTools.getClientByChannel(connection);
        if(user != null) {

                writer.writeByte(4);
                //write user data
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
                //send buffer
                connection.write(writer);

        }
    }
}
