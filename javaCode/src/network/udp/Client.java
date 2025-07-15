package network.udp;

import java.io.IOException;
import java.net.*;

public class Client {

    public static void main(String[] args) throws IOException, InterruptedException {

        /*
    public static void main(String[] var0) throws IOException, InterruptedException {
        String var1 = "172.13.14.66";
        byte[] var2 = new byte[]{11, 22, 33, 44, 55, 66, 77};

        try (DatagramSocket var3 = new DatagramSocket()) {
            DatagramPacket var4 = new DatagramPacket(var2, var2.length);
            var4.setPort(12345);
            InetAddress var5 = InetAddress.getByName(var1);
            var4.setAddress(var5);
            System.out.println("Send bytes: " + Arrays.toString(var2));
            var3.send(var4);
        }

    }
*/

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
