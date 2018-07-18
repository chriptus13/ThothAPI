package util;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public interface IRequest {
    CompletableFuture<String> getBody(String path);

    default IRequest compose(Consumer<String> cons) {
        return path -> {
            cons.accept(path);
            return getBody(path);
        };
    }
}
