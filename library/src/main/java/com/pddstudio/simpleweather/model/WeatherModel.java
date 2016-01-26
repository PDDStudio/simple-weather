package com.pddstudio.simpleweather.model;

import com.google.gson.annotations.SerializedName;

/**
 * This Class was created by Patrick J
 * on 26.01.16. For more Details and Licensing
 * have a look at the README.md
 */
public class WeatherModel {

    private int id;
    @SerializedName("main") private String shortDesc;
    @SerializedName("description") private String longDesc;

    public WeatherModel() {}

    public int getId() {
        return id;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }
}
