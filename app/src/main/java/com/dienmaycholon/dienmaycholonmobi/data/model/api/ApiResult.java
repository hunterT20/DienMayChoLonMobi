package com.dienmaycholon.dienmaycholonmobi.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiResult<T,D> {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("errorcode")
    @Expose
    private D errorcode;
    @SerializedName("data")
    @Expose
    private T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public D getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(D errorcode) {
        this.errorcode = errorcode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
