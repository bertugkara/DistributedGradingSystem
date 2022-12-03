package com.distributedstudentgradingsystem.Security.JWT;

public class MessageResponse {
    private String message;

    public MessageResponse(String message) {
        this.message = message;
        System.out.println("ben message response");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}