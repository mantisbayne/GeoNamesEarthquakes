package com.mobile.meredithbayne.geonamesearthquakes.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.reactivex.disposables.Disposable;

public class EarthquakeList {
    private Disposable disposable;

    @SerializedName("earthquakes")
    @Expose
    private List<Earthquake> earthquakes = null;

    public List<Earthquake> getEarthquakes() {
        return earthquakes;
    }

    public void setEarthquakes(List<Earthquake> earthquakes) {
        this.earthquakes = earthquakes;
    }
}
