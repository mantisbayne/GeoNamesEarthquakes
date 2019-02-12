package com.mobile.meredithbayne.geonamesearthquakes.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Earthquake {
    @SerializedName("datetime")
    @Expose
    private String datetime;

    @SerializedName("depth")
    @Expose
    private Integer depth;

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

    public Integer getDepth() {
        return depth;
    }

    public String getMagnitude() {
        return String.valueOf(magnitude);
    }

    public String getDatetime() {
        return datetime.substring(0, 5);
    }
}