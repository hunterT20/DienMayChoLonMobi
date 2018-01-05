package com.dienmaycholon.dienmaycholonmobi.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ElementProduct {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("value")
    @Expose
    private List<ValueElementProduct> value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ValueElementProduct> getValue() {
        return value;
    }

    public void setValue(List<ValueElementProduct> value) {
        this.value = value;
    }
}
