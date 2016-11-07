package com.africastalking.app.routes;

import spark.utils.StringUtils;

import static spark.Spark.post;

public class VoiceRouter extends BareBonesRouter {
    public String message;

    public void voiceRouterCall(String mesg) {
        message = mesg;
    }

    @Override
    protected void doPost() {
        post("/voice/", (req, res) -> {
            String status = req.queryParams(":isActice");
            String response = " ";

            if (status.equals("1")) {
               response ="<?xml version='1.0' encoding='UTF-8'?><Response><Say>" + message + "</Say> </Response>";
            }
            res.status(201);
            res.body(response);
            res.header("content-type", "text/plain");
            return response;
        });

    }


}

