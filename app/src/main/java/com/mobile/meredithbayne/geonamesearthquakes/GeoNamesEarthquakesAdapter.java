package com.mobile.meredithbayne.geonamesearthquakes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.mobile.meredithbayne.geonamesearthquakes.model.Earthquake;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GeoNamesEarthquakesAdapter extends
        RecyclerView.Adapter<GeoNamesEarthquakesAdapter.EarthquakesViewHolder> {
    private static final String TAG = GeoNamesEarthquakesAdapter.class.getSimpleName();
    private List<Earthquake> earthquakeList;

    public GeoNamesEarthquakesAdapter(List<Earthquake> earthquakeList) {
       earthquakeList = new ArrayList<>();
    }

    @NonNull
    @Override
    public EarthquakesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.geonames_earthquakes_item,
                        new FrameLayout(parent.getContext()), false);
        return new EarthquakesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EarthquakesViewHolder holder, int position) {
        Earthquake earthquake = earthquakeList.get(position);
        holder.setViewModel
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class EarthquakesViewHolder extends RecyclerView.ViewHolder {
        ItemDataBinding binding;
        public EarthquakesViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
