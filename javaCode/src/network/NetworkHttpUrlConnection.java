package network;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NetworkHttpUrlConnection {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://helloworld.com:8080/goodbye");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        System.out.println("Метод запроса: " + httpURLConnection.getRequestMethod());
//        System.out.println("Код ответа: " + httpURLConnection.getResponseCode());
//        System.out.println("Сообщение ответа: " + httpURLConnection.getResponseMessage());

        Map<String, List<String>> map = httpURLConnection.getHeaderFields();
        Set<String> set = map.keySet();
        for (String k : set) System.out.println("Key = " + k + ", value = " + map.get(k));
    }
}
