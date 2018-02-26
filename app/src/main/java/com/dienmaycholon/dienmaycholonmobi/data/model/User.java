package com.dienmaycholon.dienmaycholonmobi.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class User {
    @SerializedName("id")
    @PrimaryKey
    @NonNull
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
    private Object phone;
    @SerializedName("myday")
    @Expose
    private String myday;
    @SerializedName("mymonth")
    @Expose
    private Object mymonth;
    @SerializedName("myyear")
    @Expose
    private Object myyear;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("date_login")
    @Expose
    private String dateLogin;
    @SerializedName("date_created")
    @Expose
    private String dateCreated;
    @SerializedName("gettoken")
    @Expose
    private String gettoken;

    public User(@NonNull String id, String username, String email, String fullname, Object phone, String myday, Object mymonth, Object myyear, String city, String address, String dateLogin, String dateCreated, String gettoken) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.fullname = fullname;
        this.phone = phone;
        this.myday = myday;
        this.mymonth = mymonth;
        this.myyear = myyear;
        this.city = city;
        this.address = address;
        this.dateLogin = dateLogin;
        this.dateCreated = dateCreated;
        this.gettoken = gettoken;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
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

    public Object getPhone() {
        return phone;
    }

    public void setPhone(Object phone) {
        this.phone = phone;
    }

    public String getMyday() {
        return myday;
    }

    public void setMyday(String myday) {
        this.myday = myday;
    }

    public Object getMymonth() {
        return mymonth;
    }

    public void setMymonth(Object mymonth) {
        this.mymonth = mymonth;
    }

    public Object getMyyear() {
        return myyear;
    }

    public void setMyyear(Object myyear) {
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

    public String getDateLogin() {
        return dateLogin;
    }

    public void setDateLogin(String dateLogin) {
        this.dateLogin = dateLogin;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getGettoken() {
        return gettoken;
    }

    public void setGettoken(String gettoken) {
        this.gettoken = gettoken;
    }
}
