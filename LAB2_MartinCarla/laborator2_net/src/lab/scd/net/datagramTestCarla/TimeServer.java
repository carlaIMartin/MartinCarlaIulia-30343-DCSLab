package lab.scd.net.datagramTestCarla;

import java.io.*;

import java.net.*;

import java.util.*;

public class TimeServer extends Thread{

    boolean running=true;

    public TimeServer() { start();}

    public void run(){

        try{

            DatagramSocket socket = new DatagramSocket(1977);

            while(running)

            {byte[] buf = new byte[256];

            DatagramPacket packet = new DatagramPacket(buf,buf.length);

            socket.receive(packet);

//reads the client address and port no.

            InetAddress address = packet.getAddress();

            int port = packet.getPort();

            //sends a reply to the client

            buf = ((new Date()).toString()).getBytes();

            packet = new DatagramPacket(buf,buf.length,address,port);

            socket.send(packet);

        }

    }catch(Exception ex){ex.printStackTrace();}

}

    public static void main(String[] args) {

        TimeServer timeServer1 = new TimeServer();

    }

}