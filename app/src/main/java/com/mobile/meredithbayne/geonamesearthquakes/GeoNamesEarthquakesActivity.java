package com.mobile.meredithbayne.geonamesearthquakes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mobile.meredithbayne.geonamesearthquakes.ui.geonamesearthquakes.GeoNamesEarthquakesFragment;

public class GeoNamesEarthquakesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.geonames_earthquakes_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, GeoNamesEarthquakesFragment.newInstance())
                    .commitNow();
        }
    }
}
