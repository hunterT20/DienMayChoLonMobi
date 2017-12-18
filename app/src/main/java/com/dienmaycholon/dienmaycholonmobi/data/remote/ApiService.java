package com.dienmaycholon.dienmaycholonmobi.data.remote;

import com.dienmaycholon.dienmaycholonmobi.data.model.ApiListResult;
import com.dienmaycholon.dienmaycholonmobi.data.model.ApiResult;
import com.dienmaycholon.dienmaycholonmobi.data.model.ContainerProduct;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("gettoken")
    Observable<ApiResult<String>> getToken();

    @GET("viewtoken")
    Observable<ApiResult<String>> viewToken();

    @GET("containerproduct")
    Observable<ApiListResult<ContainerProduct>> getContainerProduct(@Query("token") String token);
}
