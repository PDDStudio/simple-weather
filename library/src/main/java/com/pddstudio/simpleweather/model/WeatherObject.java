package com.pddstudio.simpleweather.model;

import com.google.gson.annotations.SerializedName;

/**
 * This Class was created by Patrick J
 * on 26.01.16. For more Details and Licensing
 * have a look at the README.md
 */
public class WeatherObject {

    @SerializedName("cod") private int responseCode;
    @SerializedName("name") private String cityName;
    private int id;
    @SerializedName("weather") private WeatherModel[] weatherModel;
    @SerializedName("main") private TempModel tempModel;

    public WeatherObject() {}

    public int getResponseCode() {
        return responseCode;
    }

    public String getCityName() {
        return cityName;
    }

    public int getId() {
        return id;
    }

    public String getShortWeatherDesc() {
        if(weatherModel == null) return null;
        return weatherModel[0].getShortDesc();
    }

    public String getLongWeatherDesc() {
        if(weatherModel == null) return null;
        return weatherModel[0].getLongDesc();
    }

    public TempModel getTemperaturesInfo() {
        return tempModel;
    }

    public void setTempModel(TempModel tempModel) {
        this.tempModel = tempModel;
    }
}
