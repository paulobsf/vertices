package me.pauloferreira.vertices;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class TestVerticle extends AbstractVerticle {

    @Override public void start(Future<Void> fut) throws Exception {
        vertx
            .createHttpServer()
            .requestHandler(r -> {
                r.response().end("{\"hello\": \"vertx\"}");
            })
            .listen(8080, result -> {
                if (result.succeeded()) {
                    fut.complete();
                } else {
                    fut.fail(result.cause());
                }
            });
    }
}
