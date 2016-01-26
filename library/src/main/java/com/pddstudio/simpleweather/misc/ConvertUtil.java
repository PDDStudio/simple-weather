package com.pddstudio.simpleweather.misc;

import com.pddstudio.simpleweather.enums.TempUnit;
import com.pddstudio.simpleweather.model.TempModel;
import com.pddstudio.simpleweather.model.WeatherObject;

/**
 * This Class was created by Patrick J
 * on 26.01.16. For more Details and Licensing
 * have a look at the README.md
 */
public final class ConvertUtil {

    public static void convert(WeatherObject weatherObject, TempUnit tempUnit) {
        TempModel current = weatherObject.getTemperaturesInfo();
        switch (tempUnit) {
            case CELSIUS:
                double temp = current.getTemperature() - 273.15;
                double minTemp = current.getMinTemperature() - 273.15;
                double maxTemp = current.getMaxTemperature() - 273.15;
                current.setTemperature(temp);
                current.setMaxTemperature(maxTemp);
                current.setMinTemperature(minTemp);
                weatherObject.setTempModel(current);
                break;
            case FAHRENHEIT:
                double temp2 = current.getTemperature() * 9/5 - 459.67;
                double minTemp2 = current.getMinTemperature() * 9/5 - 459.67;
                double maxTemp2 = current.getMaxTemperature() * 9/5 - 459.67;
                current.setTemperature(temp2);
                current.setMaxTemperature(maxTemp2);
                current.setMinTemperature(minTemp2);
                weatherObject.setTempModel(current);
                break;
        }
    }

}
