package com.mobile.meredithbayne.geonamesearthquakes.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobile.meredithbayne.geonamesearthquakes.R;
import com.mobile.meredithbayne.geonamesearthquakes.model.Earthquake;

import java.util.List;

public class EarthquakesAdapter
        extends RecyclerView.Adapter<EarthquakesAdapter.EarthquakesViewHolder> {
    private List<Earthquake> earthquakes;

    public EarthquakesAdapter(List<Earthquake> earthquakes) {
        this.earthquakes = earthquakes;
    }

    @NonNull
    @Override
    public EarthquakesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.geonames_earthquakes_item, parent, false);
        return new EarthquakesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EarthquakesViewHolder earthquakesViewHolder, int position) {
        Earthquake earthquake = earthquakes.get(position);
        earthquakesViewHolder.magnitude.setText(earthquake.getMagnitude());
        earthquakesViewHolder.year.setText(earthquake.getYear());
    }

    @Override
    public int getItemCount() {
        return earthquakes.size();
    }

    class EarthquakesViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView magnitudeLabel;
        TextView magnitude;
        TextView yearLabel;
        TextView year;

        EarthquakesViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.waves);
            magnitudeLabel = itemView.findViewById(R.id.magnitude_label);
            magnitude = itemView.findViewById(R.id.magnitude_value);
            yearLabel = itemView.findViewById(R.id.year_label);
            year = itemView.findViewById(R.id.year);
        }
    }
}
