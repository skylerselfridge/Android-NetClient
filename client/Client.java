package client;

import android.util.Log;

import client.net.PipeLineFactory;
import client.obj.ClientObj;
import client.tools.Net;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.Executors;

public class Client implements Runnable{

    int port;
    String host;
    public static Channel server_connection;
    public static ClientObj user;
    public static ClientBootstrap bootstrap;
    public static Socket socket;



    public Client(int port, String host){
        this.port = port;
        this.host = host;
    }

    public void StartNetClient() throws Exception {

        ChannelFactory factory =
                new NioClientSocketChannelFactory(
                        Executors.newCachedThreadPool(),
                        Executors.newCachedThreadPool());

        bootstrap = new ClientBootstrap(factory);

        bootstrap.setPipelineFactory(new PipeLineFactory());

        bootstrap.setOption("keepAlive", true);

        server_connection = bootstrap.connect(new InetSocketAddress(this.host, this.port)).getChannel();


        Log.d("HELLO","Connected to server on port: " + this.port);


    }



    public void StopNetClient(){
        bootstrap.shutdown();
        System.out.println("Disconnected from server");
    }

    @Override
    public void run() {
        try {
            InetAddress serverAddr = InetAddress.getByName(this.host);

            socket = new Socket(serverAddr, this.port);
            Log.d("HELLO",socket.getInetAddress().toString());
            while(true) { //input loop
                if (socket.getInputStream() != null) {
                    Log.d("INPUT",socket.getInputStream().read()+"");
                }
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
