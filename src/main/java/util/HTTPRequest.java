package util;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.BoundRequestBuilder;
import org.asynchttpclient.Dsl;
import org.asynchttpclient.Response;

import java.util.concurrent.CompletableFuture;

public class HTTPRequest implements IRequest {
    private final AsyncHttpClient asyncHttpClient = Dsl.asyncHttpClient();

    @Override
    public CompletableFuture<String> getBody(String path) {
        final BoundRequestBuilder boundRequestBuilder = asyncHttpClient.prepareGet(path);
        return boundRequestBuilder.execute().toCompletableFuture().thenApply(resp -> {
            String s = resp.getResponseBody();
            System.out.println(s);
            return s;
        });
    }
}
