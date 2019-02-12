package com.mobile.meredithbayne.geonamesearthquakes.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mobile.meredithbayne.geonamesearthquakes.EarthquakesAdapter;
import com.mobile.meredithbayne.geonamesearthquakes.R;
import com.mobile.meredithbayne.geonamesearthquakes.model.Earthquake;

import java.util.List;

public class EarthquakeFragment extends Fragment implements EarthquakesInterface {

    private EarthquakePresenter presenter;
    private RecyclerView earthquakesList;
    private TextView emptyResults;
    private ProgressBar progress;
    private EarthquakesAdapter adapter;

    public static EarthquakeFragment newInstance() {
        return new EarthquakeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.earthquake_fragment, container, false);

        earthquakesList = root.findViewById(R.id.earthquakes_container);
        emptyResults = root.findViewById(R.id.no_earthquakes);
        progress = root.findViewById(R.id.loading);

        presenter = new EarthquakePresenter(this);
        presenter.loadEarthquakes();

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void displayProgressBar() {
        progress.setVisibility(View.VISIBLE);
        earthquakesList.setVisibility(View.GONE);
    }

    @Override
    public void hideProgressBar() {
        progress.setVisibility(View.GONE);
        earthquakesList.setVisibility(View.VISIBLE);
    }

    @Override
    public void displayEarthquakes(List<Earthquake> earthquakes) {
        if (earthquakes != null) {
            adapter = new EarthquakesAdapter(getActivity(), earthquakes);
            earthquakesList.setAdapter(adapter);
            earthquakesList.setVisibility(View.VISIBLE);
            earthquakesList.setHasFixedSize(true);
            progress.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void displayError(String errorMessage) {
        emptyResults.setVisibility(View.VISIBLE);
    }
}
