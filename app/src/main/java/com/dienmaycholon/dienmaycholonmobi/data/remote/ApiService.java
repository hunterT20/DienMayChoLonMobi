package com.dienmaycholon.dienmaycholonmobi.data.remote;

import com.dienmaycholon.dienmaycholonmobi.data.model.User;
import com.dienmaycholon.dienmaycholonmobi.data.model.api.ApiListResult;
import com.dienmaycholon.dienmaycholonmobi.data.model.api.ApiResult;
import com.dienmaycholon.dienmaycholonmobi.data.model.Banner;
import com.dienmaycholon.dienmaycholonmobi.data.model.Category;
import com.dienmaycholon.dienmaycholonmobi.data.model.CategoryDetail;
import com.dienmaycholon.dienmaycholonmobi.data.model.Child;
import com.dienmaycholon.dienmaycholonmobi.data.model.ContainerProduct;
import com.dienmaycholon.dienmaycholonmobi.data.model.DataLoginDMCL;
import com.dienmaycholon.dienmaycholonmobi.data.model.DataSearch;
import com.dienmaycholon.dienmaycholonmobi.data.model.ProductDetail;
import com.dienmaycholon.dienmaycholonmobi.data.model.api.AccessTokenFacebook;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("gettoken")
    Observable<ApiResult<String, Integer>> getToken();

    @GET("viewtoken")
    Observable<ApiResult<String, Integer>> viewToken();

    @GET("loadmenu")
    Observable<ApiListResult<Category>> getCategoryMenu(@Query("token") String token);

    @GET("boxslidehome")
    Observable<ApiListResult<Banner>> getBannerHome(@Query("token") String token);

    @GET("containerproduct")
    Observable<ApiListResult<ContainerProduct>> getContainerProduct(@Query("token") String token);

    @GET("searchajax/page/3")
    Observable<ApiResult<DataSearch, Integer>> getSearch(@Query("key") String key, @Query("token") String token);

    @GET("logindmcl/username/{username}/password/{password}")
    Observable<ApiResult<DataLoginDMCL, Integer>> loginDmcl(
            @Path(value = "username", encoded = true) String username,
            @Path(value = "password", encoded = true) String password,
            @Query("token") String token
    );

    @GET("getsubcategory/cate/{alias}")
    Observable<ApiResult<CategoryDetail, Integer>> getCategoryParent(
            @Path(value = "alias", encoded = true) String alias,
            @Query("token") String token
    );

    @GET("productdetail{id_detail}")
    Observable<ApiResult<ProductDetail, Integer>> getProductDetail(
            @Path(value = "id_detail", encoded = true) String category,
            @Query("token") String token
    );

    @POST("register")
    Observable<ApiResult<String, List<String>>> registerAccountDmcl(
            @Query("token") String token
    );

    @POST("cart")
    Observable<ApiResult<String, Integer>> postCart(
            @Query("token") String token,
            @Body HashMap<String,String> body
    );

    @POST("loginfacebook")
    Observable<ApiResult<User, Integer>> loginFacebook(
            @Body AccessTokenFacebook accessToken
    );
}
