package com.mobile.meredithbayne.geonamesearthquakes.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.mobile.meredithbayne.geonamesearthquakes.R;
import com.mobile.meredithbayne.geonamesearthquakes.adapter.EarthquakesAdapter;
import com.mobile.meredithbayne.geonamesearthquakes.model.Earthquake;
import com.mobile.meredithbayne.geonamesearthquakes.presenter.EarthquakesInterface;
import com.mobile.meredithbayne.geonamesearthquakes.presenter.EarthquakesPresenter;

import java.util.List;

public class EarthquakesActivity extends AppCompatActivity implements EarthquakesInterface {
    private ProgressBar loading;
    private RecyclerView earthquakesList;
    private EarthquakesAdapter adapter;
    private EarthquakesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquakes);

        if (savedInstanceState == null) {
            loading = findViewById(R.id.loading);
            earthquakesList = findViewById(R.id.earthquake_list);

            earthquakesList.setLayoutManager(new LinearLayoutManager(this));
            earthquakesList.setHasFixedSize(true);

            presenter = new EarthquakesPresenter(this);
            presenter.loadEarthquakes();
        }
    }

    @Override
    public void displayProgressBar() {
        loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        loading.setVisibility(View.INVISIBLE);
    }

    @Override
    public void displayEarthquakes(List<Earthquake> earthquakes) {
        if (earthquakes != null) {
            adapter = new EarthquakesAdapter(earthquakes);
            earthquakesList.setAdapter(adapter);
            earthquakesList.setVisibility(View.VISIBLE);
            loading.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void hideEarthquakes() {
        earthquakesList.setVisibility(View.INVISIBLE);
    }
}
