package com.winnie.rest.api;

import java.io.Serializable;

public class RestResponseWrapper implements Serializable {
    private boolean success;

    private String message;

    public RestResponseWrapper(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    public RestResponseWrapper(String message){
        this.success = true;
        this.message = message;
    }

    public RestResponseWrapper(){
        this.success = true;
        this.message = "OK";
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
