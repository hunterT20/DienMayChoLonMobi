package com.dienmaycholon.dienmaycholonmobi.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product {
    @SerializedName("myid")
    @Expose
    private String myid;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cid_series")
    @Expose
    private String cidSeries;
    @SerializedName("brand")
    @Expose
    private String brand;
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
    @SerializedName("cid_cate")
    @Expose
    private String cidCate;
    @SerializedName("rate")
    @Expose
    private String rate;
    @SerializedName("note_em")
    @Expose
    private String noteEm;
    @SerializedName("of_type")
    @Expose
    private String ofType;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("stock_num")
    @Expose
    private String stockNum;
    @SerializedName("is_shopping")
    @Expose
    private String isShopping;
    @SerializedName("is_sample")
    @Expose
    private String isSample;
    @SerializedName("note_price")
    @Expose
    private String notePrice;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("sap_code")
    @Expose
    private String sapCode;
    @SerializedName("is_vat")
    @Expose
    private String isVat;
    @SerializedName("canonical")
    @Expose
    private String canonical;
    @SerializedName("article")
    @Expose
    private Object article;
    @SerializedName("slideshow")
    @Expose
    private List<Slideshow> slideshow = null;
    @SerializedName("noteunderprice")
    @Expose
    private String noteunderprice;
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
    @SerializedName("cid_res")
    @Expose
    private String cidRes;
    @SerializedName("is_pre_order")
    @Expose
    private String isPreOrder;
    @SerializedName("pre_order")
    @Expose
    private String preOrder;
    @SerializedName("is_promotion")
    @Expose
    private String isPromotion;
    @SerializedName("tag_title")
    @Expose
    private String tagTitle;
    @SerializedName("tag_keyword")
    @Expose
    private String tagKeyword;
    @SerializedName("tag_description")
    @Expose
    private String tagDescription;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("is_tranc")
    @Expose
    private String isTranc;
    @SerializedName("is_old")
    @Expose
    private String isOld;
    @SerializedName("is_change")
    @Expose
    private String isChange;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("namecate")
    @Expose
    private String namecate;
    @SerializedName("id_detail")
    @Expose
    private String idDetail;
    @SerializedName("date_start")
    @Expose
    private String dateStart;
    @SerializedName("photo")
    @Expose
    private List<Photo> photo;

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public String getCidCate() {
        return cidCate;
    }

    public void setCidCate(String cidCate) {
        this.cidCate = cidCate;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getNoteEm() {
        return noteEm;
    }

    public void setNoteEm(String noteEm) {
        this.noteEm = noteEm;
    }

    public String getOfType() {
        return ofType;
    }

    public void setOfType(String ofType) {
        this.ofType = ofType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStockNum() {
        return stockNum;
    }

    public void setStockNum(String stockNum) {
        this.stockNum = stockNum;
    }

    public String getIsShopping() {
        return isShopping;
    }

    public void setIsShopping(String isShopping) {
        this.isShopping = isShopping;
    }

    public String getIsSample() {
        return isSample;
    }

    public void setIsSample(String isSample) {
        this.isSample = isSample;
    }

    public String getNotePrice() {
        return notePrice;
    }

    public void setNotePrice(String notePrice) {
        this.notePrice = notePrice;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSapCode() {
        return sapCode;
    }

    public void setSapCode(String sapCode) {
        this.sapCode = sapCode;
    }

    public String getIsVat() {
        return isVat;
    }

    public void setIsVat(String isVat) {
        this.isVat = isVat;
    }

    public String getCanonical() {
        return canonical;
    }

    public void setCanonical(String canonical) {
        this.canonical = canonical;
    }

    public Object getArticle() {
        return article;
    }

    public void setArticle(Object article) {
        this.article = article;
    }

    public List<Slideshow> getSlideshow() {
        return slideshow;
    }

    public void setSlideshow(List<Slideshow> slideshow) {
        this.slideshow = slideshow;
    }

    public String getNoteunderprice() {
        return noteunderprice;
    }

    public void setNoteunderprice(String noteunderprice) {
        this.noteunderprice = noteunderprice;
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

    public String getCidRes() {
        return cidRes;
    }

    public void setCidRes(String cidRes) {
        this.cidRes = cidRes;
    }

    public String getIsPreOrder() {
        return isPreOrder;
    }

    public void setIsPreOrder(String isPreOrder) {
        this.isPreOrder = isPreOrder;
    }

    public String getPreOrder() {
        return preOrder;
    }

    public void setPreOrder(String preOrder) {
        this.preOrder = preOrder;
    }

    public String getIsPromotion() {
        return isPromotion;
    }

    public void setIsPromotion(String isPromotion) {
        this.isPromotion = isPromotion;
    }

    public String getTagTitle() {
        return tagTitle;
    }

    public void setTagTitle(String tagTitle) {
        this.tagTitle = tagTitle;
    }

    public String getTagKeyword() {
        return tagKeyword;
    }

    public void setTagKeyword(String tagKeyword) {
        this.tagKeyword = tagKeyword;
    }

    public String getTagDescription() {
        return tagDescription;
    }

    public void setTagDescription(String tagDescription) {
        this.tagDescription = tagDescription;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIsTranc() {
        return isTranc;
    }

    public void setIsTranc(String isTranc) {
        this.isTranc = isTranc;
    }

    public String getIsOld() {
        return isOld;
    }

    public void setIsOld(String isOld) {
        this.isOld = isOld;
    }

    public String getIsChange() {
        return isChange;
    }

    public void setIsChange(String isChange) {
        this.isChange = isChange;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public List<Photo> getPhoto() {
        return photo;
    }

    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
    }
}
