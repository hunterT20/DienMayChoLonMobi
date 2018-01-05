package com.dienmaycholon.dienmaycholonmobi.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TDetail {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("active")
    @Expose
    private String active;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("saleprice")
    @Expose
    private String saleprice;
    @SerializedName("date_end")
    @Expose
    private String dateEnd;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("limit_quantity")
    @Expose
    private String limitQuantity;
    @SerializedName("of_type")
    @Expose
    private String ofType;
    @SerializedName("cid_product")
    @Expose
    private String cidProduct;
    @SerializedName("cid_promotion")
    @Expose
    private String cidPromotion;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("type_promo")
    @Expose
    private String typePromo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(String saleprice) {
        this.saleprice = saleprice;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getLimitQuantity() {
        return limitQuantity;
    }

    public void setLimitQuantity(String limitQuantity) {
        this.limitQuantity = limitQuantity;
    }

    public String getOfType() {
        return ofType;
    }

    public void setOfType(String ofType) {
        this.ofType = ofType;
    }

    public String getCidProduct() {
        return cidProduct;
    }

    public void setCidProduct(String cidProduct) {
        this.cidProduct = cidProduct;
    }

    public String getCidPromotion() {
        return cidPromotion;
    }

    public void setCidPromotion(String cidPromotion) {
        this.cidPromotion = cidPromotion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTypePromo() {
        return typePromo;
    }

    public void setTypePromo(String typePromo) {
        this.typePromo = typePromo;
    }
}
