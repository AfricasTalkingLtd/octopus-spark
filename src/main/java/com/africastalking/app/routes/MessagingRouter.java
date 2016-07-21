package com.africastalking.app.routes;

import com.africastalking.app.util.AfricasTalkingGateway;

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

            String message = "We are lumberjacks. We code all day and sleep all night";

            AfricasTalkingGateway gateway  = new AfricasTalkingGateway("IanJuma",
                    "fc39a99fe94b84a30941fbd7250518d8c90a7f6d3e0cbc2e9c308987a92484f5");
            gateway.sendMessage(recipients, message);

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
