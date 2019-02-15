package com.mobile.meredithbayne.geonamesearthquakes.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Earthquake {

    @SerializedName("datetime")
    @Expose
    private String datetime;
    @SerializedName("depth")
    @Expose
    private Double depth;
    @SerializedName("lng")
    @Expose
    private Double lng;
    @SerializedName("src")
    @Expose
    private String src;
    @SerializedName("eqid")
    @Expose
    private String eqid;
    @SerializedName("magnitude")
    @Expose
    private Double magnitude;
    @SerializedName("lat")
    @Expose
    private Double lat;

    public String getDatetime() {
        return datetime;
    }

    public String getYear() {
        return datetime.substring(0, 5);
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getEqid() {
        return eqid;
    }

    public void setEqid(String eqid) {
        this.eqid = eqid;
    }

    public String getMagnitude() {
        return String.valueOf(magnitude);
    }

    public void setMagnitude(Double magnitude) {
        this.magnitude = magnitude;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
}