package com.mobile.meredithbayne.geonamesearthquakes.ui.geonamesearthquakes;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.meredithbayne.geonamesearthquakes.R;

public class GeoNamesEarthquakesFragment extends Fragment {

    private GeoNamesEarthquakesViewModel mViewModel;

    public static GeoNamesEarthquakesFragment newInstance() {
        return new GeoNamesEarthquakesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.geonames_earthquakes_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(GeoNamesEarthquakesViewModel.class);
        // TODO: Use the ViewModel
    }

}
