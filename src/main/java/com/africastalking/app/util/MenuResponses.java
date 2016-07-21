package com.africastalking.app.util;


public class MenuResponses {
    final String text, sessionId, phoneNumber;

    public MenuResponses(String text, String sessionId, String phoneNumber) {
        this.text        = text;
        this.phoneNumber = phoneNumber;
        this.sessionId   = sessionId;
    }

    public String renderMenu() {
        String response;

        switch (text) {
            case ""   : response = "CON What would you want to check \n" +
                    "1. My Account \n" +
                    "2. My phone number";

            case "1"  : response = "CON Choose account information you want to view \n" +
                    "1. Account number \n" +
                    "2. Account balance";

            case "2"  : response =  String.format("END Your phone number is %s \n", phoneNumber);
            case "1*1": response =  String.format("END Your account number is %s \n", sessionId);
            default   : response =  "END Invalid input";
        }

        return response;
    }
}
