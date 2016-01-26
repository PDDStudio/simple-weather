package com.pddstudio.simpleweather.model;

import com.google.gson.annotations.SerializedName;

/**
 * This Class was created by Patrick J
 * on 26.01.16. For more Details and Licensing
 * have a look at the README.md
 */
public class TempModel {

    @SerializedName("temp") private double temperature;
    private float pressure;
    private float humidity;
    @SerializedName("temp_min") private double minTemperature;
    @SerializedName("temp_max") private double maxTemperature;

    public TempModel() {}

    public double getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }
}
