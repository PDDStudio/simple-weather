package com.pddstudio.simpleweather;

import android.util.Log;

import com.pddstudio.simpleweather.conf.UrlUtil;
import com.pddstudio.simpleweather.misc.RequestTask;
import com.pddstudio.simpleweather.misc.SimpleWeatherException;
import com.pddstudio.simpleweather.model.WeatherObject;

/**
 * This Class was created by Patrick J
 * on 26.01.16. For more Details and Licensing
 * have a look at the README.md
 */
public final class SimpleWeather {

    private WeatherRequest weatherRequest;
    private final Callback callback;

    public interface Callback {
        void onRequestStarted();
        void onRequestFailed();
        void onRequestFinished(WeatherObject weatherObject);
    }

    public SimpleWeather(Callback callback) {
        this.callback = callback;
    }

    public SimpleWeather request(WeatherRequest weatherRequest) {
        this.weatherRequest = weatherRequest;
        return this;
    }

    public void execute() {
        String url = buildUrl();
        new RequestTask(callback, url).execute();
    }

    private String buildUrl() {
        String URL = null;
        switch (weatherRequest.getRequestType()) {
            case CITY_NAME:
                URL = UrlUtil.getWeatherForCityName(weatherRequest.getRequestTime(), weatherRequest.getCityName());
                break;
            case CITY_ID:
                URL = UrlUtil.getWeatherForCityID(weatherRequest.getRequestTime(), weatherRequest.getCityId());
                break;
            case GEOGRAPHIC_COORDINATES:
                URL = UrlUtil.getWeatherForCoords(weatherRequest.getRequestTime(), weatherRequest.getCityLat(), weatherRequest.getCityLong());
                break;
            case ZIP_CODE:
                URL = UrlUtil.getWeatherForZip(weatherRequest.getRequestTime(), weatherRequest.getCityZip(), weatherRequest.getCityCC());
                break;
        }
        Log.d("SimpleWeather", "Returning URL: " + URL);
        return URL;
    }

}
