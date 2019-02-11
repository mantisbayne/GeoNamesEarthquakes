package com.mobile.meredithbayne.geonamesearthquakes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobile.meredithbayne.geonamesearthquakes.util.NetworkUtil;

public class EarthquakesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquakes);

        TextView networkError = findViewById(R.id.no_network);
        ImageView networkErrorImage = findViewById(R.id.cloud_off_icon);

        if (!NetworkUtil.isNetworkAvailable(this)) {
            networkError.setVisibility(View.VISIBLE);
            networkErrorImage.setVisibility(View.VISIBLE);
        }

        Fragment fragment = new EarthquakeListFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.earthquakes_list, fragment)
                .commit();
    }
}
