package com.dienmaycholon.dienmaycholonmobi.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductDetail {
    @SerializedName("parent_cate_name")
    @Expose
    private String parentCateName;
    @SerializedName("cate_name")
    @Expose
    private String cateName;
    @SerializedName("product")
    @Expose
    private Product product;
    @SerializedName("element_hot")
    @Expose
    private List<ElementHot> elementHot;
    @SerializedName("similar_product")
    @Expose
    private List<Child> similarProduct;
    @SerializedName("element_product")
    @Expose
    private List<ElementProduct> elementProduct;
    @SerializedName("product_history")
    @Expose
    private List<ProductHistory> productHistory;
    @SerializedName("detail_element")
    @Expose
    private DetailElement detailElement;

    public String getParentCateName() {
        return parentCateName;
    }

    public void setParentCateName(String parentCateName) {
        this.parentCateName = parentCateName;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<ElementHot> getElementHot() {
        return elementHot;
    }

    public void setElementHot(List<ElementHot> elementHot) {
        this.elementHot = elementHot;
    }

    public List<Child> getSimilarProduct() {
        return similarProduct;
    }

    public void setSimilarProduct(List<Child> similarProduct) {
        this.similarProduct = similarProduct;
    }

    public List<ElementProduct> getElementProduct() {
        return elementProduct;
    }

    public void setElementProduct(List<ElementProduct> elementProduct) {
        this.elementProduct = elementProduct;
    }

    public List<ProductHistory> getProductHistory() {
        return productHistory;
    }

    public void setProductHistory(List<ProductHistory> productHistory) {
        this.productHistory = productHistory;
    }

    public DetailElement getDetailElement() {
        return detailElement;
    }

    public void setDetailElement(DetailElement detailElement) {
        this.detailElement = detailElement;
    }
}
