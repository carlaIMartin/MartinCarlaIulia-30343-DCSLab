package lab.scd.net.datagramTestCarla;

import java.io.*;

import java.net.*;

import java.util.*;

import java.io.*;

import java.net.*;

import java.util.*;

public class Client {

    public static void main(String[] args) {

        try {
            DatagramSocket socket = new DatagramSocket();
            byte[] buf = new byte[256];
            DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("localhost"), 1977);
            socket.send(packet);


            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            System.out.println(new String(packet.getData()));

        } catch (SocketException e) {
            e.printStackTrace();


        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}