package client.packets.impl.sent;

import client.Client;

import java.io.IOException;

public class UserInformationUpdatePacket extends SPacket {


    String password;
    String first_name;
    String last_name;
    String phone_number;
    String email;

    public UserInformationUpdatePacket(String password,String first_name,String last_name,String phone_number,String email){

            //write packet number
            writer.writeByte(3);

            //write info to buffer
            writer.writeInt(password.getBytes().length);
            writer.writeBytes(password.getBytes());

            writer.writeInt(first_name.getBytes().length);
            writer.writeBytes(first_name.getBytes());

            writer.writeInt(last_name.getBytes().length);
            writer.writeBytes(last_name.getBytes());

            writer.writeInt(email.getBytes().length);
            writer.writeBytes(email.getBytes());

            writer.writeInt(phone_number.getBytes().length);
            writer.writeBytes(phone_number.getBytes());

            //send buffer
            Client.server_connection.write(writer);


    }


    @Override
    public void send_packet() {



    }
}
