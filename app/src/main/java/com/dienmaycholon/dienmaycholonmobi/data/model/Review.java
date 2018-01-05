package com.dienmaycholon.dienmaycholonmobi.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Review {
    @SerializedName("value")
    @Expose
    private ValueDetailElement value;
    @SerializedName("count")
    @Expose
    private CountDetailElement count;

    public ValueDetailElement getValue() {
        return value;
    }

    public void setValue(ValueDetailElement value) {
        this.value = value;
    }

    public CountDetailElement getCount() {
        return count;
    }

    public void setCount(CountDetailElement count) {
        this.count = count;
    }
}
