package com.africastalking.app.routes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import spark.ResponseTransformer;
import java.util.Map;

import static spark.Spark.*;

public class VoiceRouter extends BareBonesRouter {


    @Override
    protected void doPost() {

        post("/voice/", (req, resp) -> {
            System.out.println(req.body());

            Map<String, String> body = t.parse(req.body());
            String destinationNumber = body.get("destinationNumber");

            String response = "<Response>" + "<Dial phoneNumbers='+254701435178'  />"  + "</Response>";

            resp.status(200);
            return response;
        });
    }


}

