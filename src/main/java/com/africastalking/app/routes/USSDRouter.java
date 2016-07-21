package com.africastalking.app.routes;

import com.africastalking.app.util.MenuResponses;

import static spark.Spark.*;

public class USSDRouter extends BaseRouter {

    @Override
    protected void doGet() {

        get("/ussd/", (req, resp) -> {
            System.out.println(req.body());

            resp.status(201);
            resp.body("OK");
            return resp;
        });
    }

    @Override
    protected void doPost() {
        post("/ussd/", (req, resp) -> {
            System.out.println(req.body());

            String sessionId   = req.params(":sessionId");
            String phoneNumber = req.params(":phoneNumber");
            String text        = req.params(":text");

            MenuResponses menu = new MenuResponses(text, sessionId, phoneNumber);
            String response;

            response = menu.renderMenu();

            resp.status(201);
            resp.body(response);
            return resp;
        });
    }

}
