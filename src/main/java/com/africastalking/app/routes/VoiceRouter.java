package com.africastalking.app.routes;

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

            if (status.equals("1")) {
                res.body("<?xml version='1.0' encoding='UTF-8'?><Response><Say>" + message + "</Say> </Response>");
            }
            res.status(200);
            return res;
        });

    }


}

