package com.africastalking.app.routes;


import static spark.Spark.*;

public class MessagingRouter extends BareBonesRouter {

    @Override
    protected void doPost() {

        post("/sms/", (req, resp) -> {
            System.out.println(req.body());

            String from = req.params(":from");
            String to   = req.params(":to");
            String text = req.params(":text");
            String date = req.params(":date");
            String id   = req.params(":id");

            String recipients = "+254701435178";

            resp.status(200);
            return resp;
        });

        post("/dlr/", (req, resp) -> {
            System.out.println(req.body());
            String failureReason;

            String status = req.params(":status");
            String id     = req.params(":id");

            if(status.equals("Failed") || status.equals("Rejected"))
                failureReason = req.params("failureReason");

            // persist in db

            resp.status(200);
            return resp;
        });

    }

}
