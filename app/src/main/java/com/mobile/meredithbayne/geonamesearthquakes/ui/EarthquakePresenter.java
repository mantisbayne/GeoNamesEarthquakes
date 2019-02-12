package com.mobile.meredithbayne.geonamesearthquakes.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.ContentValues;

import com.mobile.meredithbayne.geonamesearthquakes.api.EarthquakeService;
import com.mobile.meredithbayne.geonamesearthquakes.api.EarthquakesClient;
import com.mobile.meredithbayne.geonamesearthquakes.model.Earthquake;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class EarthquakePresenter extends ViewModel {
    private Disposable disposable;
    private MutableLiveData<List<Earthquake>> earthquakes;
    private EarthquakesInterface mainInterface;

    public EarthquakePresenter(EarthquakesInterface mainInterface) {
        this.mainInterface = mainInterface;
    }

    public LiveData<List<Earthquake>> getEarthquakes() {
        if (earthquakes == null) {
            earthquakes = new MutableLiveData<>();
            loadEarthquakes();
        }

        return earthquakes;
    }

    private Observable<List<Earthquake>> getEarthquakesObservable() {
        return EarthquakesClient.getClient().create(EarthquakeService.class)
                .getEarthquakeList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private Observer<List<Earthquake>> getEarthquakesObserver() {
        return new Observer<List<Earthquake>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Timber.d("onSubscribe");
                disposable = d;
            }

            @Override
            public void onNext(List<Earthquake> recipes) {
                Timber.d("onNext");
                mainInterface.displayEarthquakes(recipes);
            }

            @Override
            public void onError(Throwable e) {
                Timber.e(e);
                e.printStackTrace();
                mainInterface.displayError("Could not fetch recipes");
            }

            @Override
            public void onComplete() {
                Timber.d("onComplete");
                mainInterface.hideProgressBar();
            }
        };
    }

    public void loadEarthquakes() {
        getEarthquakesObservable().subscribeWith(getEarthquakesObserver());
    }
}
