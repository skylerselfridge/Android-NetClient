package serv.util;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import serv.Server;
import serv.obj.Client;

public class ServerTools {


    public static Client getClientByChannel(Channel ctx){

        for(Client client : Server.live_clients){
            if(client.getClient_channel() == ctx){
                return client;
            }
        }
        return null;
    }


    public static String readUTF(ChannelBuffer buf, int length){
        char[] byte_cast = new char[length];
        for(int i = 0; i < length; i++){
            byte_cast[i] = (char) buf.readByte();
        }
        String result = new String(byte_cast);
        return result;
    }


}
