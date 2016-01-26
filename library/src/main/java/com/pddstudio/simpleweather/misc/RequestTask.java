package com.pddstudio.simpleweather.misc;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.pddstudio.simpleweather.SimpleWeather;
import com.pddstudio.simpleweather.WeatherRequest;
import com.pddstudio.simpleweather.enums.TempUnit;
import com.pddstudio.simpleweather.model.WeatherObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * This Class was created by Patrick J
 * on 26.01.16. For more Details and Licensing
 * have a look at the README.md
 */
public class RequestTask extends AsyncTask<Void, Void, WeatherObject> {

    private static final String LOG_TAG = "RequestTask";

    final SimpleWeather.Callback callback;
    final String requestUrl;

    public RequestTask(SimpleWeather.Callback callback, String requestUrl) {
        this.callback = callback;
        this.requestUrl = requestUrl;
    }

    @Override
    public void onPreExecute() {
        callback.onRequestStarted();
    }

    @Override
    protected WeatherObject doInBackground(Void... params) {

        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            Gson gson = new Gson();
            Request request = new Request.Builder().url(requestUrl).build();
            Response response = okHttpClient.newCall(request).execute();
            if(!response.isSuccessful()) {
                throw new IOException("Response not successful.n" + response);
            }
            String body = response.body().string();
            Log.d(LOG_TAG, "Response body:\n" + body);
            WeatherObject weatherObject = gson.fromJson(body, WeatherObject.class);
            if(weatherObject != null) {
                Log.d(LOG_TAG, "WeatherObject Status Code: " + weatherObject.getResponseCode());
                Log.d(LOG_TAG, "WeatherObject ID: " + weatherObject.getId());
                Log.d(LOG_TAG, "WeatherObject City: " + weatherObject.getCityName());
                Log.d(LOG_TAG, "WeatherObject Weather Desc: " + weatherObject.getShortWeatherDesc() + " (" + weatherObject.getLongWeatherDesc() + ")");
                Log.d(LOG_TAG, "WeatherObject Temperatures: " + weatherObject.getTemperaturesInfo().getTemperature() + "°");
                Log.d(LOG_TAG, "WeatherObject Min Temperature: " + weatherObject.getTemperaturesInfo().getMinTemperature() + "°");
                Log.d(LOG_TAG, "WeatherObject Max Temperature: " + weatherObject.getTemperaturesInfo().getMaxTemperature() + "°");
                Log.d(LOG_TAG, "WeatherObject Humidity: " + weatherObject.getTemperaturesInfo().getHumidity() + "");
                return weatherObject;
            } else {
                Log.d(LOG_TAG, "Unable to resolve response into WeatherObject.");
            }
        } catch (IOException io) {
            io.printStackTrace();
            Log.e(LOG_TAG, "Request failed.");
            cancel(true);
        }

        return null;
    }

    @Override
    protected void onCancelled() {
        callback.onRequestFailed();
    }

    @Override
    public void onPostExecute(WeatherObject weatherObject) {
        if(weatherObject == null) callback.onRequestFailed();
        else callback.onRequestFinished(weatherObject);
    }


}
