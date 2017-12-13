package com.dienmaycholon.dienmaycholonmobi.data.model;

public class Product {
    private String name;
    private long price;
    private long priceDel;

    public Product(String name, long price, long priceDel) {
        this.name = name;
        this.price = price;
        this.priceDel = priceDel;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getPriceDel() {
        return priceDel;
    }

    public void setPriceDel(long priceDel) {
        this.priceDel = priceDel;
    }
}
