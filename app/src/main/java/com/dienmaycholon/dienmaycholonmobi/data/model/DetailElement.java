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

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getSapCode() {
        return sapCode;
    }

    public void setSapCode(String sapCode) {
        this.sapCode = sapCode;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public TDetail gettDetail() {
        return tDetail;
    }

    public void settDetail(TDetail tDetail) {
        this.tDetail = tDetail;
    }

    public PromotionText getPromotionText() {
        return promotionText;
    }

    public void setPromotionText(PromotionText promotionText) {
        this.promotionText = promotionText;
    }
}
