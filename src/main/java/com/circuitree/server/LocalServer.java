package com.circuitree.server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class LocalServer {
    private final HttpServer server;
    private final int port;

    public LocalServer(String html) throws IOException {
        byte[] bytes = html.getBytes(StandardCharsets.UTF_8);
        server = HttpServer.create(new InetSocketAddress("localhost", 0), 0);
        port = server.getAddress().getPort();
        server.createContext("/", exchange -> {
            exchange.getResponseHeaders().set("Content-Type", "text/html; charset=utf-8");
            exchange.sendResponseHeaders(200, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        });
        server.setExecutor(null);
    }

    public void start() {
        server.start();
        System.out.println("Serving at http://localhost:" + port);
    }

    public int getPort() {
        return port;
    }

}
