package com.dienmaycholon.dienmaycholonmobi.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailElement {
    @SerializedName("cate_name")
    @Expose
    private String cateName;
    @SerializedName("series_name")
    @Expose
    private String seriesName;
    @SerializedName("sap_code")
    @Expose
    private String sapCode;
    @SerializedName("review")
    @Expose
    private Review review;
    @SerializedName("rate")
    @Expose
    private String rate;
    @SerializedName("TDetail")
    @Expose
    private TDetail tDetail;
    @SerializedName("promotionText")
    @Expose
    private PromotionText promotionText;
}
