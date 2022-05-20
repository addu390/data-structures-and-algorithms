package systemDesign.rest;

// REpresentational State Transfer
// https://www.educative.io/edpresso/how-to-make-a-rest-api-in-java
// https://github.com/piczmar/pure-java-rest-api

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.util.*;
import java.util.regex.Pattern;
import java.net.URLDecoder;

import static java.util.stream.Collectors.*;

// 1. HTTP Server, PORT, Methods (GET, POST, PUT, PATCH and DELETE).
// 2. URLDecoder and Parsing the query strings (/api/greeting?firstname=john&lastnames=de,re&age=20): Map<String, List<String>>
// 3. Serializer: Convert String to defined Objects (Integer, Float, Datetime...)
// 4. Service Class
// 5. Return the response (Success or Failure).

/**
 * RESTful web services use HTTP.
 * Common methods: GET, POST, PUT, and DELETE.
 * Service Discovery: Every resource or object has its own specific URI (Uniform Resource Identifier).
 * Stateless: All interactions with a resource are stateless
 */

public class API {
    public static void start() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/api/greeting", (exchange -> {

            if ("GET".equals(exchange.getRequestMethod())) {
                Map<String, List<String>> params = splitQuery(exchange.getRequestURI().getRawQuery());
                System.out.print(params);

                String responseText = "Hello World!\n";
                exchange.sendResponseHeaders(200, responseText.getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(responseText.getBytes());
                output.flush();
            } else if ("POST".equals(exchange.getRequestMethod())) {
                // Object mapper to parse the class.
            } else {
                exchange.sendResponseHeaders(405, -1); // 405 Method Not Allowed
            }
            exchange.close();
        }));


        server.setExecutor(null); // creates a default executor
        server.start();
    }

    public static Map<String, List<String>> splitQuery(String query) {
        if (query == null || "".equals(query)) {
            return Collections.emptyMap();
        }

        return Pattern.compile("&").splitAsStream(query)
                .map(s -> Arrays.copyOf(s.split("="), 2))
                .collect(groupingBy(s -> decode(s[0]), mapping(s -> decode(s[1]), toList())));
    }

    private static String decode(final String encoded) {
        try {
            return encoded == null ? null : URLDecoder.decode(encoded, "UTF-8");
        } catch (final UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 is a required encoding", e);
        }
    }

    class Request {
        private Integer id;
        private String name;

        public Request() {
            id = 0;
            name = "Temp";
        }

        public Request(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
    }


}
