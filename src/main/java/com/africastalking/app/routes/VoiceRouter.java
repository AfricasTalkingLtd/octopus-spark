package com.africastalking.app.routes;

<<<<<<< HEAD
import spark.utils.StringUtils;

=======
>>>>>>> b31dff02ddfe2b6b346ce3a5098d2c9431219351
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
<<<<<<< HEAD
            String response = " ";

            if (status.equals("1")) {
               response ="<?xml version='1.0' encoding='UTF-8'?><Response><Say>" + message + "</Say> </Response>";
            }
            res.status(201);
            res.body(response);
            res.header("content-type", "text/plain");
            return response;
=======

            if (status.equals("1")) {
                res.body("<?xml version='1.0' encoding='UTF-8'?><Response><Say>" + message + "</Say> </Response>");
            }
            res.status(200);
            return res;
>>>>>>> b31dff02ddfe2b6b346ce3a5098d2c9431219351
        });

    }


}

