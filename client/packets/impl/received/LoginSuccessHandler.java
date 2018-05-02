package client.packets.impl.received;

import client.Client;
import client.obj.ClientObj;
import client.packets.Packet;
import client.packets.PacketHandler;
import client.tools.Stringer;
import org.jboss.netty.buffer.ChannelBuffer;


import java.io.IOException;

public class LoginSuccessHandler implements PacketHandler {
    @Override
    public void handle(Packet p, ChannelBuffer buf) {
        //create channelbufferinput stream for reading multiple formats

            //read in information
            int length;
            ChannelBuffer new_buf;

            //read username
            length = buf.readInt();
            new_buf = buf.readBytes(length);
            String username = Stringer.readUTF(new_buf,length);

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

            //set up local client obj
            Client.user = new ClientObj(username,password);
            //set vars
            Client.user.setFirst_name(first_name);
            Client.user.setLast_name(last_name);
            Client.user.setEmail(email);
            Client.user.setPhone_number(phone);

            //alert client
            System.out.println("Successfully logged in, Welcome " +  Client.user.getFirst_name());




    }
}
