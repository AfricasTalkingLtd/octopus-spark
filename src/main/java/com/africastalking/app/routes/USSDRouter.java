package com.africastalking.app.routes;

import com.africastalking.app.model.Model;
import com.africastalking.app.util.Call;
import com.africastalking.app.util.Message;
import com.google.gson.Gson;

import java.sql.ResultSet;

import static spark.Spark.get;
import static spark.Spark.post;


public class USSDRouter extends BaseRouter {

    final private static Gson gson = new Gson();

    ///////////////////////// define a post method /////////////////////

    @Override
    protected void doPost() {
        post("/ussd/", (req, res) -> {

            ///////////////////// Acquire parameters received from api ///////////////////////

            String sessionId = req.queryParams("sessionId");
            String serviceCode = req.queryParams("serviceCode");
            String phoneNumber = req.queryParams("phoneNumber");
            String text = req.queryParams("text");

            /////// Determine which response to send to the api and eventually user///////////////////////////

            String response, message = "The best things in life are free";

            /////////////////////////////// handle null reference pointer incase of any //////////////////////
            if (text == null) {
                text = "";
            }

            ////////////////////// loop through server response of text to determine next course of action /////////

            switch (text) {
                case "":
                    response = "CON What service would you like \n" +
                            "1. A voice call from Africa`s Talking\n" +
                            "2. SMS from Africa`s Talking ";
                    break;

                case "1":
                    response = "END Thank you, You will receive a phone call from Africa`s talking shortly \n";
                    new Call().call(message, phoneNumber);
                    break;

                case "2":
                    response = "END Thank you, You will receive an SMS from Africa`s talking shortly \n";
                    new Message().sms(message, phoneNumber);
                    break;
                default:
                    response = "END Invalid input";
            }
            ///////////////////////// Update to DB /////////////////////////////
            String sql = String.format("INSERT INTO USSD (phonenumber, sessionid, text) VALUES (%s %s %s)", phoneNumber, sessionId, text);

            try {
                new Model().update(sql);
            } catch (Exception e) {
                System.out.println(e);
            }

            //////////////////////////////// Return Response to server //////////////////////////////////////////////
            res.header("content-type", "text/plain");
            res.status(201);
            res.body(response);
            return response;
        });
    }


//    //////////////////////////////// Return Response //////////////////////////////////////////////
//            res.body(response);
//            return res;


    @Override
    protected void doGet() {

        get("/ussd/", (req, res) -> {
            System.out.println(req.body());

            res.type("application/json");
            res.status(200);

            String sql = "select * from ussd";
            Model model = new Model();
            ResultSet rs = model.select(sql);
            return rs;
        }, gson::toJson);

    }


}
