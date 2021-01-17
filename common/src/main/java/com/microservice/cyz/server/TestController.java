package com.microservice.cyz.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * @author 崔耀中
 * @since 2021-01-12
 */
public class TestController {

    public static void main(String[] arg) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(9998), 0);

        server.createContext("/", new TestHandler());
        server.start();
    }

    static  class TestHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
//            System.out.println("receive message from: "+ exchange.getRequestURI());
//            String response = BuildResponse.generate();
//            String requestBody = IOUtils.toString(exchange.getRequestBody(), Charset.defaultCharset().toString());
//            System.out.println("requestBody is: "+requestBody);
//            System.out.println("responseBody is: "+response);
//            exchange.sendResponseHeaders(200, 00);
//            OutputStream os = exchange.getResponseBody();
//            os.write(response.getBytes());
//            os.close();
        }
    }

}
