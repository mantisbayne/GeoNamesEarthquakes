package com.mobile.meredithbayne.geonamesearthquakes.api;

import com.mobile.meredithbayne.geonamesearthquakes.model.Earthquake;

import java.util.List;
import io.reactivex.Observable;

import retrofit2.http.GET;

public interface EarthquakeService {
    @GET("earthquakesJSON?formatted=true&north=44.1&south=-9.9&east=-22.4&west=55.2" +
            "&username=mkoppelman")
    Observable<List<Earthquake>> getEarthquakeList();
}
