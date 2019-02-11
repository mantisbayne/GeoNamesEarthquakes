package com.mobile.meredithbayne.geonamesearthquakes.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import static android.content.Context.CONNECTIVITY_SERVICE;

public class NetworkUtil {
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);

        NetworkInfo info = connectivityManager != null ?
                connectivityManager.getActiveNetworkInfo() : null;
        return info != null && info.isConnected();
    }
}