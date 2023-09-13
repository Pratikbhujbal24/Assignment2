import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ChuckNorrisJokeFetcher {
    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.chucknorris.io/jokes/random"))
                .build();

        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(ChuckNorrisJokeFetcher::handleResponse)
                .join();
    }

    private static void handleResponse(String responseBody) {
        System.out.println("Chuck Norris Joke:");
        System.out.println(responseBody);
    }
}
