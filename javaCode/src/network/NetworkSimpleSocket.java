package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class NetworkSimpleSocket {

    public static void main(String[] args) {
        try (Socket s = new Socket("localhost", 12345)) {
            int c = 0;
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            String string = "Hello world";
            byte[] b = string.getBytes();
            out.write(b);
            while ((c = in.read()) != -1) System.out.println((char) c);
        } catch (IOException e) {
            System.out.println("Socket not create");
        }
    }
}
