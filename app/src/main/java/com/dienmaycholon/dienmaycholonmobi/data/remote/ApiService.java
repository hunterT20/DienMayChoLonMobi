package com.dienmaycholon.dienmaycholonmobi.data.remote;

import com.dienmaycholon.dienmaycholonmobi.data.model.Token;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("default/server/gettoken")
    Call<Token> repoToken();
}
