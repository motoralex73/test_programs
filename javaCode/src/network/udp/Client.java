package network.udp;

import java.io.IOException;
import java.net.*;

public class Client {

    public static void main(String[] args) throws IOException, InterruptedException {

        String ip = "172.13.14.66";
        byte[] bytes = {11,22,33,44,55,66,77};
        try ( DatagramSocket socket = new DatagramSocket() ) {
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
            packet.setPort(12345);
            InetAddress inetAddress = InetAddress.getByName(ip);
            packet.setAddress(inetAddress);
            System.out.println("Send bytes: " + java.util.Arrays.toString(bytes));
            socket.send(packet);
        }
    }
}
