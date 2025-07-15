package network;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class NetworkUrlConnection {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://helloworld.com:8080/goodbye");
        URLConnection urlConnection = url.openConnection();
        System.out.println(url.getPort());
        System.out.println(url.getHost());
        System.out.println(url.getFile());
        System.out.println("get date: " + urlConnection.getDate()+", get expiration: " + urlConnection.getExpiration());
        System.out.println();
    }
}
