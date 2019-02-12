package com.mobile.meredithbayne.geonamesearthquakes.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.meredithbayne.geonamesearthquakes.R;

public class EarthquakeFragment extends Fragment {

    private EarthquakeViewModel mViewModel;

    public static EarthquakeFragment newInstance() {
        return new EarthquakeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.earthquake_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(EarthquakeViewModel.class);
        // TODO: Use the ViewModel
    }

}
