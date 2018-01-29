package com.dienmaycholon.dienmaycholonmobi.data.remote;

public class ApiUtils {

    public ApiUtils() {
    }

    private static final String ROOT = "https://dienmaycholon.vn";
    private static final String BASE_URL = ROOT + "/default/server/";

    private static final String TEST_URL = "https://e511a1da.ngrok.io/default/server/";

    public static ApiService getAPIservices(){
        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }
}
