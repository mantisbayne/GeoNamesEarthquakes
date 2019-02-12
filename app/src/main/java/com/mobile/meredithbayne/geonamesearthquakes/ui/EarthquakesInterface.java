package com.mobile.meredithbayne.geonamesearthquakes.ui;

import com.mobile.meredithbayne.geonamesearthquakes.model.Earthquake;

import java.util.List;

public interface EarthquakesInterface {
    void displayProgressBar();
    void hideProgressBar();
    void displayEarthquakes(List<Earthquake> recipes);
    void displayError(String errorMessage);
}
