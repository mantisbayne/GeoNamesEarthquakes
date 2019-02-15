package com.mobile.meredithbayne.geonamesearthquakes.presenter;

import android.util.Log;

import com.mobile.meredithbayne.geonamesearthquakes.api.EarthquakesClient;
import com.mobile.meredithbayne.geonamesearthquakes.api.EarthquakesService;
import com.mobile.meredithbayne.geonamesearthquakes.model.Earthquake;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class EarthquakesPresenter {
    private static final String TAG = EarthquakesPresenter.class.getSimpleName();

    private EarthquakesInterface earthquakesInterface;
    private Disposable disposable;

    public EarthquakesPresenter(EarthquakesInterface earthquakesInterface) {
        this.earthquakesInterface = earthquakesInterface;
    }

    private Observable<List<Earthquake>> getEarthquakesObservable() {
        return EarthquakesClient.getRetrofitInstance()
                .create(EarthquakesService.class)
                .getEarthquakes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private Observer<List<Earthquake>> getEarthquakesObserver() {
        return new Observer<List<Earthquake>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe");
                disposable = d;
            }

            @Override
            public void onNext(List<Earthquake> earthquakes) {
                Log.d(TAG, "onNext");
                earthquakesInterface.displayEarthquakes(earthquakes);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError");
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
                earthquakesInterface.hideProgressBar();
            }
        };
    }

    public void loadEarthquakes() {
        getEarthquakesObservable().subscribeWith(getEarthquakesObserver());
    }
}
