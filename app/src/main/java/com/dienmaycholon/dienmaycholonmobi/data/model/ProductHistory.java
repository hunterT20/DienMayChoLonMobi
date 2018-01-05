package com.dienmaycholon.dienmaycholonmobi.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductHistory {
    @SerializedName("myid")
    @Expose
    private String myid;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cid_series")
    @Expose
    private String cidSeries;
    @SerializedName("isprice")
    @Expose
    private String isprice;
    @SerializedName("is_icon")
    @Expose
    private String isIcon;
    @SerializedName("is_model")
    @Expose
    private String isModel;
    @SerializedName("is_price")
    @Expose
    private String isPrice;
    @SerializedName("is_flash_sale")
    @Expose
    private String isFlashSale;
    @SerializedName("is_sale")
    @Expose
    private String isSale;
    @SerializedName("new_description")
    @Expose
    private String newDescription;
    @SerializedName("is_red_day")
    @Expose
    private String isRedDay;
    @SerializedName("is_double_price")
    @Expose
    private String isDoublePrice;
    @SerializedName("is_million")
    @Expose
    private String isMillion;
    @SerializedName("coupons")
    @Expose
    private String coupons;
    @SerializedName("discountcoupons")
    @Expose
    private String discountcoupons;
    @SerializedName("discount")
    @Expose
    private String discount;
    @SerializedName("saleprice")
    @Expose
    private String saleprice;
    @SerializedName("is_promotion")
    @Expose
    private String isPromotion;
    @SerializedName("namecate")
    @Expose
    private String namecate;
    @SerializedName("cid_res")
    @Expose
    private String cidRes;
    @SerializedName("attribute")
    @Expose
    private List<Attribute> attribute;

    public String getMyid() {
        return myid;
    }

    public void setMyid(String myid) {
        this.myid = myid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCidSeries() {
        return cidSeries;
    }

    public void setCidSeries(String cidSeries) {
        this.cidSeries = cidSeries;
    }

    public String getIsprice() {
        return isprice;
    }

    public void setIsprice(String isprice) {
        this.isprice = isprice;
    }

    public String getIsIcon() {
        return isIcon;
    }

    public void setIsIcon(String isIcon) {
        this.isIcon = isIcon;
    }

    public String getIsModel() {
        return isModel;
    }

    public void setIsModel(String isModel) {
        this.isModel = isModel;
    }

    public String getIsPrice() {
        return isPrice;
    }

    public void setIsPrice(String isPrice) {
        this.isPrice = isPrice;
    }

    public String getIsFlashSale() {
        return isFlashSale;
    }

    public void setIsFlashSale(String isFlashSale) {
        this.isFlashSale = isFlashSale;
    }

    public String getIsSale() {
        return isSale;
    }

    public void setIsSale(String isSale) {
        this.isSale = isSale;
    }

    public String getNewDescription() {
        return newDescription;
    }

    public void setNewDescription(String newDescription) {
        this.newDescription = newDescription;
    }

    public String getIsRedDay() {
        return isRedDay;
    }

    public void setIsRedDay(String isRedDay) {
        this.isRedDay = isRedDay;
    }

    public String getIsDoublePrice() {
        return isDoublePrice;
    }

    public void setIsDoublePrice(String isDoublePrice) {
        this.isDoublePrice = isDoublePrice;
    }

    public String getIsMillion() {
        return isMillion;
    }

    public void setIsMillion(String isMillion) {
        this.isMillion = isMillion;
    }

    public String getCoupons() {
        return coupons;
    }

    public void setCoupons(String coupons) {
        this.coupons = coupons;
    }

    public String getDiscountcoupons() {
        return discountcoupons;
    }

    public void setDiscountcoupons(String discountcoupons) {
        this.discountcoupons = discountcoupons;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(String saleprice) {
        this.saleprice = saleprice;
    }

    public String getIsPromotion() {
        return isPromotion;
    }

    public void setIsPromotion(String isPromotion) {
        this.isPromotion = isPromotion;
    }

    public String getNamecate() {
        return namecate;
    }

    public void setNamecate(String namecate) {
        this.namecate = namecate;
    }

    public String getCidRes() {
        return cidRes;
    }

    public void setCidRes(String cidRes) {
        this.cidRes = cidRes;
    }

    public List<Attribute> getAttribute() {
        return attribute;
    }

    public void setAttribute(List<Attribute> attribute) {
        this.attribute = attribute;
    }
}
