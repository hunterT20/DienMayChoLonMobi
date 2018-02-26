package com.dienmaycholon.dienmaycholonmobi.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Color {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("is_status_cate")
    @Expose
    private String isStatusCate;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("isprice")
    @Expose
    private String isprice;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("sap_code")
    @Expose
    private String sapCode;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cid_product")
    @Expose
    private String cidProduct;
    @SerializedName("option")
    @Expose
    private String option;
    @SerializedName("cid_supplier")
    @Expose
    private String cidSupplier;
    @SerializedName("color_code")
    @Expose
    private String colorCode;
    @SerializedName("photo")
    @Expose
    private List<Photo> photo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsStatusCate() {
        return isStatusCate;
    }

    public void setIsStatusCate(String isStatusCate) {
        this.isStatusCate = isStatusCate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsprice() {
        return isprice;
    }

    public void setIsprice(String isprice) {
        this.isprice = isprice;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCidProduct() {
        return cidProduct;
    }

    public void setCidProduct(String cidProduct) {
        this.cidProduct = cidProduct;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getCidSupplier() {
        return cidSupplier;
    }

    public void setCidSupplier(String cidSupplier) {
        this.cidSupplier = cidSupplier;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public List<Photo> getPhoto() {
        return photo;
    }

    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
    }
}
