package com.mobile.meredithbayne.geonamesearthquakes.viewmodel;

import android.util.Log;

import com.mobile.meredithbayne.geonamesearthquakes.BR;
import com.mobile.meredithbayne.geonamesearthquakes.GeoNamesEarthquakesAdapter;
import com.mobile.meredithbayne.geonamesearthquakes.api.EarthquakesClient;
import com.mobile.meredithbayne.geonamesearthquakes.model.Earthquake;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GeoNamesEarthquakesViewModel extends BaseObservable {
    private static final String TAG = GeoNamesEarthquakesViewModel.class.getSimpleName();
    private GeoNamesEarthquakesAdapter adapter;
    private List<Earthquake> data;
    private EarthquakeListInterface earthquakeListInterface;
    private Disposable disposable;

    public GeoNamesEarthquakesViewModel(GeoNamesEarthquakesAdapter adapter, List<Earthquake> data) {
        adapter = new GeoNamesEarthquakesAdapter();
        data = new ArrayList<>();
    }

    public void setUp() {
        getEarthquakes();
    }

    public void tearDown() {
        // perform tear down tasks, such as removing listeners
    }

    @Bindable
    public List<Earthquake> getData() {
        return this.data;
    }

    @Bindable
    public GeoNamesEarthquakesAdapter getAdapter() {
        return this.adapter;
    }

    private Observable<List<Earthquake>> getEarthquakesObservable() {
        return EarthquakesClient.getService().create(EarthquakesClient.EarthquakesService.class)
                .getEarthquakes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private Observer<List<Earthquake>> getEarthquakessObserver() {
        return new Observer<List<Earthquake>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe");
                disposable = d;
            }

            @Override
            public void onNext(List<Earthquake> earthquakes) {
                Log.d(TAG, "onNext");
                earthquakeListInterface.displayEarthquakes(earthquakes);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError");
                e.printStackTrace();
                earthquakeListInterface.displayError("Could not fetch recipes");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
                earthquakeListInterface.hideProgressBar();
            }
        };
    }

    private void getEarthquakes() {
        getEarthquakesObservable().subscribeWith(getEarthquakessObserver());
    }

    public interface EarthquakeListInterface {
        void displayProgressBar();
        void hideProgressBar();
        void displayEarthquakes(List<Earthquake> earthquakes);
        void displayError(String errorMessage);
    }

}
