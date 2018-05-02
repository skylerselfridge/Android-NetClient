package serv.packets.received;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBufferInputStream;
import serv.SQL.stmnts.createUser;
import serv.packets.Packet;
import serv.packets.PacketHandler;
import serv.packets.impl.sent.ErrorPacket;
import serv.packets.impl.sent.RegistrationSuccessPacket;
import serv.util.ServerTools;

import java.io.IOException;

public class RegistrationHandler implements PacketHandler {
    @Override
    public void handle(Packet p, ChannelBuffer buf) {

            int length;
            ChannelBuffer new_buf;

            //read username
            length = buf.readInt();
            new_buf = buf.readBytes(length);
            String username = ServerTools.readUTF(new_buf,length);

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
            String phone = ServerTools.readUTF(new_buf,length);


            createUser user_creation_sql = new createUser();
            user_creation_sql.setQuery(username,password,first_name,last_name,email,phone,p.getChannel());
            boolean result = user_creation_sql.query();

            if(result){
                System.out.println("User creation success: username:["+username+"]");
                RegistrationSuccessPacket regSucc = new RegistrationSuccessPacket(p.getChannel());
                regSucc.send_packet();
            } else {
                System.out.println("User creation fail");
            }



    }
}
