package com.junaid.userregister.entity;

import java.lang.reflect.Type;

public class Response {

    Boolean status;
    String message;
    Type obj;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Type getObj() {
        return obj;
    }

    public void setObj(Type obj) {
        this.obj = obj;
    }
}
