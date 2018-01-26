package com.dienmaycholon.dienmaycholonmobi.data.model;

import android.widget.LinearLayout;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryDetail {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cate_child")
    @Expose
    private List<CategoryChild> categoryChildren;
    @SerializedName("list_child")
    @Expose
    private List<CategoryDetailProduct> categoryDetailProducts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoryChild> getCategoryChildren() {
        return categoryChildren;
    }

    public void setCategoryChildren(List<CategoryChild> categoryChildren) {
        this.categoryChildren = categoryChildren;
    }

    public List<CategoryDetailProduct> getCategoryDetailProducts() {
        return categoryDetailProducts;
    }

    public void setCategoryDetailProducts(List<CategoryDetailProduct> categoryDetailProducts) {
        this.categoryDetailProducts = categoryDetailProducts;
    }
}
