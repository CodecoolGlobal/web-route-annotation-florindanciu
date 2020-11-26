package com.codecool;

import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

public class Application {

    public static void main(String[] args) throws Exception {

        Routes routes = new Routes();
        RoutesMethods routesMethods = new RoutesMethods();

        MyHandler myHandler = new MyHandler(routes, routesMethods);

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/test1", myHandler);
        server.createContext("/test2", myHandler);
        server.createContext("/usersPost", myHandler);
        server.createContext("/usersPut", myHandler);
        server.createContext("/usersDelete", myHandler);
        server.setExecutor(null); // creates a default executor
        server.start();
    }
}