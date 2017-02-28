package com.example.ramprasad.e1_weatherapp1.interfaces;

import android.location.Location;

import com.example.ramprasad.e1_weatherapp1.parse.Info;

/**
 * Created by Ramprasad on 1/18/2015.
 */
public interface TaskCommunicator {

    void getWeatherData(Info info);
    void getLocation(Location location);
}
