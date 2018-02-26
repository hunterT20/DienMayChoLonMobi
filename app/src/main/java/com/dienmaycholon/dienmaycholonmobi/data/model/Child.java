package com.dienmaycholon.dienmaycholonmobi.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity
public class Child {
    @SerializedName("myid")
    @PrimaryKey
    @NonNull
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
    @Ignore
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
    @SerializedName("cid_res")
    @Expose
    private String cidRes;
    @SerializedName("namecate")
    @Expose
    private String namecate;
    @SerializedName("id_detail")
    @Expose
    private String idDetail;
    @SerializedName("detail_link_web")
    @Expose
    private String detailLinkWeb;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("gift")
    @Expose
    private Integer gift;
    @SerializedName("element_special")
    @Ignore
    @Expose
    private List<ElementSpecial> elementSpecial;
    @SerializedName("color")
    @Ignore
    @Expose
    private List<Color> colors;
    private int count = 1;
    private int colorChoose;

    public int getColorChoose() {
        return colorChoose;
    }

    public void setColorChoose(int colorChoose) {
        this.colorChoose = colorChoose;
    }

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @NonNull
    public String getMyid() {
        return myid;
    }

    public void setMyid(@NonNull String myid) {
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

    public String getCidRes() {
        return cidRes;
    }

    public void setCidRes(String cidRes) {
        this.cidRes = cidRes;
    }

    public String getNamecate() {
        return namecate;
    }

    public void setNamecate(String namecate) {
        this.namecate = namecate;
    }

    public String getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(String idDetail) {
        this.idDetail = idDetail;
    }

    public String getDetailLinkWeb() {
        return detailLinkWeb;
    }

    public void setDetailLinkWeb(String detailLinkWeb) {
        this.detailLinkWeb = detailLinkWeb;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getGift() {
        return gift;
    }

    public void setGift(Integer gift) {
        this.gift = gift;
    }

    public List<ElementSpecial> getElementSpecial() {
        return elementSpecial;
    }

    public void setElementSpecial(List<ElementSpecial> elementSpecial) {
        this.elementSpecial = elementSpecial;
    }
}
