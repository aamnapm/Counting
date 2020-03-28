package com.aamnapm.counting.dto;

import org.json.JSONObject;

import java.util.UUID;

public class ResponseApi {

    private boolean status;
    private String message;
    private UUID result;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UUID getResult() {
        return result;
    }

    public void setResult(UUID result) {
        this.result = result;
    }
}
