package network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {

    public static void main(String[] args) throws IOException {

        int port = 12345;
        try (DatagramSocket socket = new DatagramSocket(port)) {
            System.out.println("Udp server start port = " + port);
            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
            while (true) {
                socket.receive(packet);
                for (int i = 0; i < packet.getLength(); i++) {System.out.print(bytes[i]);} System.out.println();
            }
        }
    }
}
