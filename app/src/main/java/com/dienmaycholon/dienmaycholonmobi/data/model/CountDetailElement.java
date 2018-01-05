package com.dienmaycholon.dienmaycholonmobi.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountDetailElement {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("cid_product")
    @Expose
    private String cidProduct;
    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("cid_review")
    @Expose
    private String cidReview;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCidProduct() {
        return cidProduct;
    }

    public void setCidProduct(String cidProduct) {
        this.cidProduct = cidProduct;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCidReview() {
        return cidReview;
    }

    public void setCidReview(String cidReview) {
        this.cidReview = cidReview;
    }
}
