package com.pddstudio.simpleweathersample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.pddstudio.simpleweather.SimpleWeather;
import com.pddstudio.simpleweather.WeatherRequest;
import com.pddstudio.simpleweather.enums.RequestTime;
import com.pddstudio.simpleweather.enums.RequestType;
import com.pddstudio.simpleweather.enums.TempUnit;
import com.pddstudio.simpleweather.misc.ConvertUtil;
import com.pddstudio.simpleweather.model.WeatherObject;

public class MainActivity extends AppCompatActivity implements SimpleWeather.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WeatherRequest weatherRequest = new WeatherRequest.Builder(RequestType.CITY_NAME).withRequestTime(RequestTime.CURRENT).withCityName("Karlsruhe").build();
                new SimpleWeather(MainActivity.this).request(weatherRequest).execute();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRequestStarted() {
        Log.d("MainActivity", "onRequestStared()");
    }

    @Override
    public void onRequestFailed() {
        Log.d("MainActivity", "onRequestFailed()");
    }

    @Override
    public void onRequestFinished(WeatherObject weatherObject) {
        Log.d("MainActivity", "onRequestFinished()");
        ConvertUtil.convert(weatherObject, TempUnit.CELSIUS);
        ((TextView) findViewById(R.id.testLabel)).setText(weatherObject.getCityName() + " [ Temperature: " + weatherObject.getTemperaturesInfo().getTemperature() + "°C ]");
    }
}
