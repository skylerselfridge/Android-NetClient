package client.packets.impl.sent;

import client.Client;

import java.io.IOException;

public class RegistrationPacket extends SPacket {

    String username;
    String password;
    String first_name;
    String last_name;
    String email;
    String phone;



    public RegistrationPacket(String username, String password, String first_name, String last_name, String email, String phone){
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
    }


    @Override
    public void send_packet() {


            //write packet number
            writer.writeByte(2);

            //send data
            writer.writeInt(username.getBytes().length);
            writer.writeBytes(username.getBytes());

            writer.writeInt(password.getBytes().length);
            writer.writeBytes(password.getBytes());

            writer.writeInt(first_name.getBytes().length);
            writer.writeBytes(first_name.getBytes());

            writer.writeInt(last_name.getBytes().length);
            writer.writeBytes(last_name.getBytes());

            writer.writeInt(email.getBytes().length);
            writer.writeBytes(email.getBytes());

            writer.writeInt(phone.getBytes().length);
            writer.writeBytes(phone.getBytes());



        //send the written buffer to server
        Client.server_connection.write(writer);

    }
}
