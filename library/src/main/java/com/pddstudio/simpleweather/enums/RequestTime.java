package com.pddstudio.simpleweather.enums;

import com.pddstudio.simpleweather.conf.Conf;

/**
 * This Class was created by Patrick J
 * on 26.01.16. For more Details and Licensing
 * have a look at the README.md
 */
public enum RequestTime {
    CURRENT(Conf.QUERY_PARAM_CURRENT_WEATHER),
    FORECAST(Conf.QUERY_PARAM_FORECAST_WEATHER);

    final String re;

    RequestTime(String s) {
        this.re = s;
    }

    public String getParam() {
        return re;
    }

}
