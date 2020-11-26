package com.codecool;

public class Routes {

    @WebRoute(path = "/test1")
    public String test1Method() {
        return "This is test1 method";
    }

    @WebRoute(path = "/test2")
    public String test2Method() {
        return "This is test2 method";
    }

    @WebRoute(method = Methods.POST, path = "/usersPost")
    public String usersPost() {
        return "This is users method using POST";
    }

    @WebRoute(method = Methods.PUT, path = "/usersPut")
    public String usersPut() {
        return "This is users method using PUT";
    }

    @WebRoute(method = Methods.DELETE, path = "/usersDelete")
    public String usersDelete() {
        return "This is users method using DELETE";
    }

    @WebRoute(path = "/user/<userName>") // need to implement the WebRoute interface
    public String user(String userName) {
        return "User name is: " + userName;
    }
}
