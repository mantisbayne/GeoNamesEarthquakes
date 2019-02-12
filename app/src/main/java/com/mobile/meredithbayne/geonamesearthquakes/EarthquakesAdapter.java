package com.mobile.meredithbayne.geonamesearthquakes;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobile.meredithbayne.geonamesearthquakes.model.Earthquake;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;

public class EarthquakesAdapter extends RecyclerView.Adapter<EarthquakesAdapter.EarthquakeViewHolder> {

    private List<Earthquake> earthquakeList = new ArrayList<>();
    private Context context;

    public interface EarthquakeClickListener {
        void onEarthquakeClick(int position);
    }

    public EarthquakesAdapter(Context context, List<Earthquake> earthquakeList) {
        this.context = context;
        this.earthquakeList = earthquakeList;
    }

    @NonNull
    @Override
    public EarthquakeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.earthquake_item, parent, false);
        return new EarthquakeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EarthquakeViewHolder holder, int position) {
        Earthquake earthquake = getEarthquakeItem(position);
        setDescriptionBasedOnDepth(holder, earthquake.getDepth());
        holder.year.setText(earthquake.getDatetime());
        setMagnitudeBasedOnStrength(holder, earthquake);
    }

    private void setDescriptionBasedOnDepth(EarthquakeViewHolder holder, Integer depth) {
        if (depth >= 100) {
            holder.description.setText(R.string.deep);
        }
        holder.description.setText(R.string.shallow);
    }

    private void setMagnitudeBasedOnStrength(EarthquakeViewHolder holder, Earthquake earthquake) {
        if (earthquake.getMagnitude() >= 7.9) {
            holder.magnitude.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
        }
        holder.magnitude.setText(earthquake.getMagnitudeAsText());
    }

    public Earthquake getEarthquakeItem(int id) {
        return earthquakeList == null ? null : earthquakeList.get(id);
    }

    @Override
    public int getItemCount() {
        return earthquakeList.size();
    }

    class EarthquakeViewHolder extends RecyclerView.ViewHolder {
        TextView description;
        TextView year;
        TextView magnitude;

        EarthquakeViewHolder(View itemView) {
            super(itemView);

            description = itemView.findViewById(R.id.quake_description);
            year = itemView.findViewById(R.id.year);
            magnitude = itemView.findViewById(R.id.magnitude);
        }
    }
}
