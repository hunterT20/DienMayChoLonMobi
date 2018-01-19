package com.dienmaycholon.dienmaycholonmobi.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
    @SerializedName("ordering")
    @Expose
    private String ordering;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("cid_parent")
    @Expose
    private String cidParent;
    @SerializedName("has_coupon")
    @Expose
    private String hasCoupon;
    @SerializedName("tag_title")
    @Expose
    private String tagTitle;
    @SerializedName("tag_keyword")
    @Expose
    private String tagKeyword;
    @SerializedName("tag_description")
    @Expose
    private String tagDescription;
    @SerializedName("links_left")
    @Expose
    private Object linksLeft;
    @SerializedName("links_right")
    @Expose
    private Object linksRight;
    @SerializedName("links_banner_top")
    @Expose
    private Object linksBannerTop;
    @SerializedName("link_banner_left_bottom")
    @Expose
    private String linkBannerLeftBottom;
    @SerializedName("cate_description")
    @Expose
    private Object cateDescription;
    @SerializedName("cate_banner")
    @Expose
    private Object cateBanner;
    @SerializedName("created")
    @Expose
    private Object created;
    @SerializedName("photo_one")
    @Expose
    private String photoOne;
    @SerializedName("photo_two")
    @Expose
    private String photoTwo;
    @SerializedName("photo_tg")
    @Expose
    private String photoTg;
    @SerializedName("icon")
    @Expose
    private String icon;

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

    public String getOrdering() {
        return ordering;
    }

    public void setOrdering(String ordering) {
        this.ordering = ordering;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCidParent() {
        return cidParent;
    }

    public void setCidParent(String cidParent) {
        this.cidParent = cidParent;
    }

    public String getHasCoupon() {
        return hasCoupon;
    }

    public void setHasCoupon(String hasCoupon) {
        this.hasCoupon = hasCoupon;
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

    public Object getLinksLeft() {
        return linksLeft;
    }

    public void setLinksLeft(Object linksLeft) {
        this.linksLeft = linksLeft;
    }

    public Object getLinksRight() {
        return linksRight;
    }

    public void setLinksRight(Object linksRight) {
        this.linksRight = linksRight;
    }

    public Object getLinksBannerTop() {
        return linksBannerTop;
    }

    public void setLinksBannerTop(Object linksBannerTop) {
        this.linksBannerTop = linksBannerTop;
    }

    public String getLinkBannerLeftBottom() {
        return linkBannerLeftBottom;
    }

    public void setLinkBannerLeftBottom(String linkBannerLeftBottom) {
        this.linkBannerLeftBottom = linkBannerLeftBottom;
    }

    public Object getCateDescription() {
        return cateDescription;
    }

    public void setCateDescription(Object cateDescription) {
        this.cateDescription = cateDescription;
    }

    public Object getCateBanner() {
        return cateBanner;
    }

    public void setCateBanner(Object cateBanner) {
        this.cateBanner = cateBanner;
    }

    public Object getCreated() {
        return created;
    }

    public void setCreated(Object created) {
        this.created = created;
    }

    public String getPhotoOne() {
        return photoOne;
    }

    public void setPhotoOne(String photoOne) {
        this.photoOne = photoOne;
    }

    public String getPhotoTwo() {
        return photoTwo;
    }

    public void setPhotoTwo(String photoTwo) {
        this.photoTwo = photoTwo;
    }

    public String getPhotoTg() {
        return photoTg;
    }

    public void setPhotoTg(String photoTg) {
        this.photoTg = photoTg;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
