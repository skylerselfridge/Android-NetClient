package client.packets.impl.sent;

import client.Client;

import java.io.IOException;

public class LoginPacket extends SPacket {

    String username;
    String password;


    public LoginPacket(String username,String password){
        this.username = username;
        this.password = password;
    }


    @Override
    public void send_packet() {



            //write packet number
            writer.writeByte(1);
            //write username
            writer.writeInt(username.getBytes().length);
            writer.writeBytes(username.getBytes());
            //write password
            writer.writeInt(password.getBytes().length);
            writer.writeBytes(password.getBytes());



        //send the written buffer to server
        Client.server_connection.write(writer);
    }
}
