package com.dienmaycholon.dienmaycholonmobi.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataLoginDMCL {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("fullname")
    @Expose
    private String fullname;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("myday")
    @Expose
    private String myday;
    @SerializedName("mymonth")
    @Expose
    private String mymonth;
    @SerializedName("myyear")
    @Expose
    private String myyear;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("gettoken")
    @Expose
    private String gettoken;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMyday() {
        return myday;
    }

    public void setMyday(String myday) {
        this.myday = myday;
    }

    public String getMymonth() {
        return mymonth;
    }

    public void setMymonth(String mymonth) {
        this.mymonth = mymonth;
    }

    public String getMyyear() {
        return myyear;
    }

    public void setMyyear(String myyear) {
        this.myyear = myyear;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGettoken() {
        return gettoken;
    }

    public void setGettoken(String gettoken) {
        this.gettoken = gettoken;
    }
}
