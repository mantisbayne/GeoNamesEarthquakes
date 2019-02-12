package com.mobile.meredithbayne.geonamesearthquakes.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.mobile.meredithbayne.geonamesearthquakes.model.Earthquake;

import java.util.List;

public class EarthquakeViewModel extends ViewModel {
    private MutableLiveData<List<Earthquake>> earthquakes;

    public LiveData<List<Earthquake>> getEarthquakes() {
        if (earthquakes == null) {
            earthquakes = new MutableLiveData<>();
            loadEarthquakes();
        }

        return earthquakes;
    }

    private void loadEarthquakes() {

    }
}
