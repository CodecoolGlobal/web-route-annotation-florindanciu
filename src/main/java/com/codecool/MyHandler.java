package com.codecool;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyHandler implements HttpHandler {

    private final Routes routes;
    private final RoutesMethods routesMethods;

    public MyHandler(Routes routes, RoutesMethods routesMethods) {
        this.routes = routes;
        this.routesMethods = routesMethods;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        String response = "No response";

        String requestMethod = httpExchange.getRequestMethod();

        String requestPath = httpExchange.getRequestURI().getPath();

        Method classMethod = this.routesMethods.getMethods().get(requestMethod).get(requestPath);

        String accessMethod = classMethod.getAnnotation(WebRoute.class).method().name();

        if (!requestMethod.equals(accessMethod)) {
            response = "Method not allowed, this route takes only " + accessMethod + " method";
        } else {
            try {
                response = classMethod.invoke(routes) + ", request method is: " + requestMethod;
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
