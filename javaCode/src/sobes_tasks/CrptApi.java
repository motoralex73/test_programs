import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.locks.ReentrantLock;

public class CrptApi {
    private final TimeUnit timeUnit;
    private final int requestLimit;
    private final HttpClient httpClient;
    private final String apiUrl = "https://ismp.crpt.ru/api/v3/lk/documents/create";

    private int requestCount = 0;
    private long lastResetTime = System.currentTimeMillis();
    private final ReentrantLock lock = new ReentrantLock();

    public CrptApi(TimeUnit timeUnit, int requestLimit) {
        if (requestLimit <= 0) {
            throw new IllegalArgumentException("Request limit can be greater than 0");
        }
        this.timeUnit = timeUnit;
        this.requestLimit = requestLimit;
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(30))
                .build();
    }

    public void createDocument(Document document, String token) {
        lock.lock();
        try {
            waitingLimit();
            requestCount++;
            sendHttpRequest(document, token);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Request was interrupted", e);
        } finally {
            lock.unlock();
        }
    }

    private void waitingLimit() throws InterruptedException {
        long currentTime = System.currentTimeMillis();
        long timeWaiting = timeUnit.toMillis(1);

        if (currentTime - lastResetTime >= timeWaiting) {
            requestCount = 0;
            lastResetTime = currentTime;
            return;
        }

        if (requestCount >= requestLimit) {
            long timeToWait = lastResetTime + timeWaiting - currentTime;
            if (timeToWait > 0) {
                Thread.sleep(timeToWait);
            }
            requestCount = 0;
            lastResetTime = System.currentTimeMillis();
        }
    }

    private void sendHttpRequest(Document document, String token) {
        try {
            String requestBody = createRequestBody(document);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl + "?pg=" + document))
                    .header("content-type", "application/json")
                    .header("Authorization", "Bearer " + token)
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .timeout(Duration.ofSeconds(3))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            processResponse(response.body());

        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Failed to send HTTP request", e);
        }
    }

    private String createRequestBody(Document document) {
        return String.format(
                "{" +
                        "\"document_format\":\"%s\"," +
                        "\"product_document\":\"%s\"," +
                        "\"product_group\":\"%s\"," +
                        "\"signature\":\"%s\"," +
                        "\"type\":\"%s\"" +
                        "}",
                document.getDocumentFormat(),
                document.getProductDocument(),
                document.getProductGroup(),
                document.getSignature(),
                document.getType()
        );
    }

    private void processResponse(String responseBody) {
        System.out.println("API Response: " + responseBody);
    }


    public static class Document {
        private final String documentFormat;
        private final String productDocument;
        private final String productGroup;
        private final String signature;
        private final String type;

        public Document(String documentFormat, String productDocument, String productGroup, String signature, String type) {
            this.documentFormat = documentFormat;
            this.productDocument = productDocument;
            this.productGroup = productGroup;
            this.signature = signature;
            this.type = type;
        }

        public String getDocumentFormat() {
            return documentFormat;
        }

        public String getProductDocument() {
            return productDocument;
        }

        public String getProductGroup() {
            return productGroup;
        }

        public String getSignature() {
            return signature;
        }

        public String getType() {
            return type;
        }
    }

    public static void main(String[] args) {
        CrptApi api = new CrptApi(TimeUnit.SECONDS, 100); // 100 запросов в секунду

        Document doc = new Document(
                "MANUAL",
                "Документ в base64",
                "milk group",
                "Открепленная подпись в base64",
                "LP_INTRODUCE_GOODS"
        );

        api.createDocument(doc, "auth-token");
    }
}
