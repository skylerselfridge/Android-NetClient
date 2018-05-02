package client.packets.impl.received;

import client.Client;
import client.packets.Packet;
import client.packets.PacketHandler;
import client.tools.Stringer;
import org.jboss.netty.buffer.ChannelBuffer;


import java.io.IOException;

public class UserUpdateHandler implements PacketHandler {
    @Override
    public void handle(Packet p, ChannelBuffer buf) {

            int length;
            ChannelBuffer new_buf;

            //read password
            length = buf.readInt();
            new_buf = buf.readBytes(length);
            String password = Stringer.readUTF(new_buf,length);

            //read first name
            length = buf.readInt();
            new_buf = buf.readBytes(length);
            String first_name = Stringer.readUTF(new_buf,length);

            //read last name
            length = buf.readInt();
            new_buf = buf.readBytes(length);
            String last_name = Stringer.readUTF(new_buf,length);


            //read email
            length = buf.readInt();
            new_buf = buf.readBytes(length);
            String email = Stringer.readUTF(new_buf,length);

            //read phone
            length = buf.readInt();
            new_buf = buf.readBytes(length);
            String phone = Stringer.readUTF(new_buf,length);

            Client.user.setPassword(password);
            Client.user.setFirst_name(first_name);
            Client.user.setLast_name(last_name);
            Client.user.setEmail(email);
            Client.user.setPhone_number(phone);


            System.err.println("User update successful");



    }
}
