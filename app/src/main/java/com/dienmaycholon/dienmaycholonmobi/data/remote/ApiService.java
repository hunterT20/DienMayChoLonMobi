package com.dienmaycholon.dienmaycholonmobi.data.remote;

import com.dienmaycholon.dienmaycholonmobi.data.model.ApiListResult;
import com.dienmaycholon.dienmaycholonmobi.data.model.ApiResult;
import com.dienmaycholon.dienmaycholonmobi.data.model.Banner;
import com.dienmaycholon.dienmaycholonmobi.data.model.Category;
import com.dienmaycholon.dienmaycholonmobi.data.model.CategoryChild;
import com.dienmaycholon.dienmaycholonmobi.data.model.ContainerProduct;
import com.dienmaycholon.dienmaycholonmobi.data.model.ProductDetail;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("gettoken")
    Observable<ApiResult<String>> getToken();

    @GET("viewtoken")
    Observable<ApiResult<String>> viewToken();

    @GET("loadmenu")
    Observable<ApiListResult<Category>> getCategoryMenu(@Query("token") String token);

    @GET("boxslidehome")
    Observable<ApiListResult<Banner>> getBannerHome(@Query("token") String token);

    @GET("containerproduct")
    Observable<ApiListResult<ContainerProduct>> getContainerProduct(@Query("token") String token);

    @GET("productdetail{id_detail}")
    Observable<ApiResult<ProductDetail>> getProductDetail(
            @Path(value = "id_detail", encoded = true) String category,
            @Query("token") String token
    );
}
