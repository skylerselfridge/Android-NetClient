package client;

import client.net.PipeLineFactory;
import client.obj.ClientObj;
import client.tools.Net;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Client {

    int port;
    String host;
    public static Channel server_connection;
    public static ClientObj user;
    public static ClientBootstrap bootstrap;


    public static void main(String[] args){
        Client client = new Client(8000,"127.0.0.1");
        try {
            client.StartNetClient();
            Net.login("Taco","Bell");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

        System.out.println("Connected to server on port: " + this.port);


    }


    public void StopNetClient(){
        bootstrap.shutdown();
        System.out.println("Disconnected from server");
    }

}
