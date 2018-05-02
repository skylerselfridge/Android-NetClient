package client.tools;

import org.jboss.netty.buffer.ChannelBuffer;

public class Stringer {

    public static String readUTF(ChannelBuffer buf, int length){
        char[] byte_cast = new char[length];
        for(int i = 0; i < length; i++){
            byte_cast[i] = (char) buf.readByte();
        }
        String result = new String(byte_cast);
        return result;
    }

}
