package com.dienmaycholon.dienmaycholonmobi.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attribute {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("val")
    @Expose
    private String val;
    @SerializedName("cid_product")
    @Expose
    private String cidProduct;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getCidProduct() {
        return cidProduct;
    }

    public void setCidProduct(String cidProduct) {
        this.cidProduct = cidProduct;
    }
}
