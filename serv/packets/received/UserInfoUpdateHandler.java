package serv.packets.received;


import serv.packets.Packet;
import serv.packets.PacketHandler;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBufferInputStream;
import serv.obj.Client;
import serv.packets.impl.sent.ErrorPacket;
import serv.util.ServerTools;

import java.io.IOException;
import java.nio.channels.Channel;

public class UserInfoUpdateHandler implements PacketHandler {

    @Override
    public void handle(Packet p, ChannelBuffer buf) {

            int length;
            ChannelBuffer new_buf;

            //read password
            length = buf.readInt();
            new_buf = buf.readBytes(length);
            String password = ServerTools.readUTF(new_buf,length);


            //read first name
            length = buf.readInt();
            new_buf = buf.readBytes(length);
            String first_name = ServerTools.readUTF(new_buf,length);

            //read last name
            length = buf.readInt();
            new_buf = buf.readBytes(length);
            String last_name = ServerTools.readUTF(new_buf,length);


            //read email
            length = buf.readInt();
            new_buf = buf.readBytes(length);
            String email = ServerTools.readUTF(new_buf,length);

            //read phone
            length = buf.readInt();
            new_buf = buf.readBytes(length);
            String phone_number = ServerTools.readUTF(new_buf,length);

            Client user = ServerTools.getClientByChannel(p.getChannel());
            if(user != null){ //user exists so we can update it
                user.setPassword(password);
                user.setFirst_name(first_name);
                user.setLast_name(last_name);
                user.setPhone_number(phone_number);
                user.setEmail(email);
                user.updateUserInformationOnDB();
            } else {
                //send update error null account
                ErrorPacket ep = new ErrorPacket((byte)5,p.getChannel());
                ep.send_packet();
            }



    }
}
