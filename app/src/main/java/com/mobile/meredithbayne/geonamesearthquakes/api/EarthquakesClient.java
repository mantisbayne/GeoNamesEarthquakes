package com.mobile.meredithbayne.geonamesearthquakes.api;

import com.mobile.meredithbayne.geonamesearthquakes.model.Earthquake;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class EarthquakesClient {
    private static final String BASE_URL = "http://api.geonames.org";
    private static Retrofit retrofit;

    public static Retrofit getService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

    public interface EarthquakesService {
        @GET("/earthquakesJSON?formatted=true&north=44.1&south=-9.9&east=-22.4&west=55.2" +
                "&username=mkoppelman")
        Observable<List<Earthquake>> getEarthquakes();
    }
}
