package com.dienmaycholon.dienmaycholonmobi.data.remote;

public class ApiUtils {

    public ApiUtils() {
    }

    public static final String ROOT = "https://48bf8ff4.ngrok.io";
    private static final String BASE_URL = ROOT + "/default/server/";

    public static ApiService getAPIservices(){
        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }
}
