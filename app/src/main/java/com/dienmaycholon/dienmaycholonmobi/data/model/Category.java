package com.dienmaycholon.dienmaycholonmobi.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Category {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("alias")
    @Expose
    private String alias;
    @SerializedName("cate_description")
    @Expose
    private String cateDescription;
    @SerializedName("cate_banner")
    @Expose
    private List<CateBanner> cateBanner;
    @SerializedName("child")
    @Expose
    private List<CategoryChild> categoryChildList;

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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCateDescription() {
        return cateDescription;
    }

    public void setCateDescription(String cateDescription) {
        this.cateDescription = cateDescription;
    }

    public List<CateBanner> getCateBanner() {
        return cateBanner;
    }

    public void setCateBanner(List<CateBanner> cateBanner) {
        this.cateBanner = cateBanner;
    }

    public List<CategoryChild> getCategoryChildList() {
        return categoryChildList;
    }

    public void setCategoryChildList(List<CategoryChild> categoryChildList) {
        this.categoryChildList = categoryChildList;
    }
}
