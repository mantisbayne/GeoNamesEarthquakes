package com.mobile.meredithbayne.geonamesearthquakes.presenter;

import com.mobile.meredithbayne.geonamesearthquakes.model.Earthquake;

import java.util.List;

public interface EarthquakesInterface {
    void displayProgressBar();
    void hideProgressBar();
    void displayEarthquakes(List<Earthquake> earthquakes);
    void hideEarthquakes();
}
