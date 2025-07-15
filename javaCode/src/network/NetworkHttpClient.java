package network;

import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NetworkHttpClient {

    public static void main(String[] args) throws Exception {

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI("http://www.google.com")).build();
        HttpResponse<InputStream> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofInputStream());

        System.out.println("Код ответа: " + httpResponse.statusCode());
        System.out.println("Метод запроса: " + httpRequest.method());

        HttpHeaders httpHeaders = httpResponse.headers();
        Map<String, List<String>> headerMap = httpHeaders.map();
        Set<String> headerSet = headerMap.keySet();

        System.out.println("------------------- Header: ");
        for (String k : headerSet) System.out.println("Key: " + k + ", value: " + headerMap.get(k));

        System.out.println("------------------- Body:");
        InputStream inputStream = httpResponse.body();
        int c;
        while ( (c = inputStream.read()) != -1) System.out.print((char)c);
        System.out.println();
    }
}
