package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class NetworkDatagram {

    public static int serverPort = 998;
    public static int clientPort = 999;
    public static int bufferSize = 1024;
    public static DatagramSocket ds;
    public static byte[] buffer = new byte[bufferSize];

    public static void receiveServer() throws IOException {
        int pos = 0;
        while (true) {
            int c = System.in.read();
            switch (c) {
                case -1 -> {
                    System.out.println("Сервер завершает сеанс связи.");
                    ds.close();
                    return;
                }
                case '\r' -> {
                    break;
                }
                case '\n' -> {
                    ds.send(new DatagramPacket(buffer, pos, InetAddress.getLocalHost(), clientPort));
                    pos = 0;
                    break;
                }
                default -> buffer[pos++] = (byte) c;
            }
        }
    }

    public static void sendClient() throws IOException {
        while(true) {
            DatagramPacket p = new DatagramPacket(buffer, buffer.length);
            ds.receive(p);
            System.out.println(new String(p.getData(),0,p.getLength()));
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 1) {
            ds = new DatagramSocket(serverPort);
            receiveServer();
        }
        else {
            ds = new DatagramSocket(clientPort);
            sendClient();
        }
    }
}
