package com.africastalking.app;

import static spark.Spark.*;

import com.africastalking.app.routes.MessagingRouter;
import com.africastalking.app.routes.USSDRouter;


public class App {

    public static void main(String[] args) {
        int maxThreads = 8;
        int minThreads = 2;
        port(8000);
        int timeOutMillis = 30000;
        threadPool(maxThreads, minThreads, timeOutMillis);

        before((request, response) -> {
            System.out.println(request);
        });

        after((request, response) -> {
            response.header("Content-Encoding", "gzip");
        });

        (new USSDRouter()).initiate();
        (new MessagingRouter()).initiate();
    }
}
