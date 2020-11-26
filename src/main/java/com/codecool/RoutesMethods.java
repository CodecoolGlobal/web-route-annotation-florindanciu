package com.codecool;

import java.lang.reflect.Method;
import java.util.HashMap;

public class RoutesMethods {

    private final HashMap<String, HashMap<String, Method>> methods = new HashMap<>();
    private final HashMap<String, Method> paths = new HashMap<>();

    public RoutesMethods() {
        setPaths();
    }

    private void setPaths() {
        for (Method routesMethod : Routes.class.getMethods()) {
            if (routesMethod.isAnnotationPresent(WebRoute.class)) {
                String path = routesMethod.getAnnotation(WebRoute.class).path();
                String method = routesMethod.getAnnotation(WebRoute.class).method().name();
                paths.put(path, routesMethod);
                methods.put(method, paths);
            }
        }
    }

    public HashMap<String, HashMap<String, Method>> getMethods() {
        return methods;
    }
}
