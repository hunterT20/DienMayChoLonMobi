package com.dienmaycholon.dienmaycholonmobi.data.remote;

public class ApiUtils {

    public ApiUtils() {
    }

    private static final String ROOT = "https://dienmaycholon.vn";
    private static final String BASE_URL = ROOT + "/default/server/";

    private static final String TEST_URL = "https://265ee01b.ngrok.io/default/server/";

    public static ApiService getAPIservices(){
        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }

    public static ApiService getAPIservicesTest(){
        return RetrofitClient.getClient(TEST_URL).create(ApiService.class);
    }
}
