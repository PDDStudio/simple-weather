package com.pddstudio.simpleweather.conf;

import com.pddstudio.simpleweather.enums.RequestTime;

/**
 * This Class was created by Patrick J
 * on 26.01.16. For more Details and Licensing
 * have a look at the README.md
 */
public final class UrlUtil {

    private static String appendApiKey() {
        return Conf.QUERY_PARAM_API_KEY + Conf.API_KEY;
    }

    public static String getBaseUrl() {
        return Conf.API_BASE_URL;
    }

    public static String getApiKey() {
        return Conf.API_KEY;
    }

    public static String getWeatherForCityName(RequestTime requestTime, String cityName) {
        return Conf.API_BASE_URL + requestTime.getParam() + Conf.QUERY_PARAM_CITY_NAME + cityName + appendApiKey();
    }

    public static String getWeatherForCityID(RequestTime requestTime, int cityId) {
        return Conf.API_BASE_URL + requestTime.getParam() + Conf.QUERY_PARAM_CITY_ID + cityId + appendApiKey();
    }

    public static String getWeatherForCoords(RequestTime requestTime, int lat, int lon) {
        return Conf.API_BASE_URL + requestTime.getParam() + Conf.QUERY_PARAM_LAT + lat + Conf.QUERY_PARAM_LONG + lon + appendApiKey();
    }

    public static String getWeatherForZip(RequestTime requestTime, int zipCode, String countryCode) {
        if(countryCode == null) {
            return Conf.API_BASE_URL + requestTime.getParam() + Conf.QUERY_PARAM_ZIP_CODE + zipCode + appendApiKey();
        } else {
            return Conf.API_BASE_URL + requestTime.getParam() + Conf.QUERY_PARAM_ZIP_CODE + zipCode + "," + countryCode + appendApiKey();
        }
    }

}
