package com.dienmaycholon.dienmaycholonmobi.data.model;

import java.util.List;

public class ItemIndex {
    private String title;
    private List<Product> productList;

    public ItemIndex(String title, List<Product> productList) {
        this.title = title;
        this.productList = productList;
    }

    public ItemIndex() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
