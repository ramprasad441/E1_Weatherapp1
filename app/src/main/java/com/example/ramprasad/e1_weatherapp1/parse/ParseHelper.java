package com.example.ramprasad.e1_weatherapp1.parse;

import com.google.gson.Gson;

/**
 * Created by Ramprasad on 1/18/2015.
 */
public class ParseHelper {

    public static Info getParsedData(String rawJson) {


        Gson gson = new Gson();
        Info info = gson.fromJson(rawJson, Info.class);

        return info;

    }
}
