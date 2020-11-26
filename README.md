# web-route-annotation-florindanciu

Your task is to create a mini-webserver that uses reflection and annotations to route browser requests to specific handler methods.

You might have already seen something similar if you've used Flask's routing mechanism, e.g. @app.route('/hello') or if you've written Java Servlet-based webapps, e.g. @WebServlet("/hello").

You will see later on that Spring does something similar with its @RestController and @GetMapping annotations.

Details
Use the built-in webserver available from Java 8 and in later version.

See the documentation of its features.
Refer to the documentation of the HttpExchange class, which encapsulates an HTTP request and response as well.
Here's a quickstart guide.
Your task is to create a custom annotation called @WebRoute which can be used to annotate methods. Methods annotated with @WebRoute("/path") will be your HTTP request handlers. They are called whenever a request accepted by the webserver matches the "/path" value in a @WebRoute annotation.

Use reflection to find the right method for an incoming request.
