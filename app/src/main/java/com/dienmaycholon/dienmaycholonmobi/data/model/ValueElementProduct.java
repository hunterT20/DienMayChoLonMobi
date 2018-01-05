package com.dienmaycholon.dienmaycholonmobi.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ValueElementProduct {
    @SerializedName("cid_product")
    @Expose
    private String cidProduct;
    @SerializedName("cid_element")
    @Expose
    private String cidElement;
    @SerializedName("val")
    @Expose
    private String val;
    @SerializedName("is_type")
    @Expose
    private String isType;
    @SerializedName("cid_parent")
    @Expose
    private String cidParent;
    @SerializedName("is_hot")
    @Expose
    private String isHot;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("links")
    @Expose
    private String links;
    @SerializedName("description")
    @Expose
    private String description;

    public String getCidProduct() {
        return cidProduct;
    }

    public void setCidProduct(String cidProduct) {
        this.cidProduct = cidProduct;
    }

    public String getCidElement() {
        return cidElement;
    }

    public void setCidElement(String cidElement) {
        this.cidElement = cidElement;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getIsType() {
        return isType;
    }

    public void setIsType(String isType) {
        this.isType = isType;
    }

    public String getCidParent() {
        return cidParent;
    }

    public void setCidParent(String cidParent) {
        this.cidParent = cidParent;
    }

    public String getIsHot() {
        return isHot;
    }

    public void setIsHot(String isHot) {
        this.isHot = isHot;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
