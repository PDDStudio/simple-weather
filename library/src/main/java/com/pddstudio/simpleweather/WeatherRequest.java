package com.pddstudio.simpleweather;

import com.pddstudio.simpleweather.enums.RequestTime;
import com.pddstudio.simpleweather.enums.RequestType;

/**
 * This Class was created by Patrick J
 * on 26.01.16. For more Details and Licensing
 * have a look at the README.md
 */
public final class WeatherRequest {

    private final RequestType requestType;
    private final String cityName;
    private final int cityId;
    private final int cityLat;
    private final int cityLong;
    private final int cityZip;
    private final String cityCC;
    private final RequestTime requestTime;

    private WeatherRequest(Builder builder) {
        this.requestType = builder.requestType;
        this.requestTime = builder.requestTime;
        switch (requestType) {
            case CITY_ID:
                this.cityId = builder.cityID;
                this.cityName = null;
                this.cityLat = -1;
                this.cityLong = -1;
                this.cityZip = -1;
                this.cityCC = null;
                break;
            case CITY_NAME:
                this.cityId = -1;
                this.cityName = builder.cityName;
                this.cityLat = -1;
                this.cityLong = -1;
                this.cityZip = -1;
                this.cityCC = null;
                break;
            case GEOGRAPHIC_COORDINATES:
                this.cityId = -1;
                this.cityName = null;
                this.cityLat = builder.cityLat;
                this.cityLong = builder.cityLong;
                this.cityZip = -1;
                this.cityCC = null;
                break;
            case ZIP_CODE:
                this.cityId = -1;
                this.cityName = null;
                this.cityLat = -1;
                this.cityLong = -1;
                this.cityZip = builder.cityZip;
                this.cityCC = builder.cityZipCountry;
                break;
            default:
                this.cityName = null;
                this.cityId = -1;
                this.cityLat = -1;
                this.cityLong = -1;
                this.cityZip = -1;
                this.cityCC = null;
                break;
        }
    }

    protected RequestType getRequestType() {
        return requestType;
    }

    protected String getCityName() {
        return cityName;
    }

    protected int getCityId() {
        return cityId;
    }

    protected int getCityLat() {
        return cityLat;
    }

    protected int getCityLong() {
        return cityLong;
    }

    protected int getCityZip() {
        return cityZip;
    }

    protected String getCityCC() {
        return cityCC;
    }

    protected RequestTime getRequestTime() {
        return requestTime;
    }

    public static class Builder {

        final RequestType requestType;
        RequestTime requestTime = RequestTime.CURRENT;

        String cityName = null;
        int cityID = -1;
        int cityLat = -1;
        int cityLong = -1;
        int cityZip = -1;
        String cityZipCountry = null;

        public Builder(RequestType requestType) {
            this.requestType = requestType;
        }

        public Builder withRequestTime(RequestTime requestTime) {
            this.requestTime = requestTime;
            return this;
        }

        public Builder withCityName(String cityName) {
            this.cityName = cityName;
            return this;
        }

        public Builder withCityID(int cityID) {
            this.cityID = cityID;
            return this;
        }

        public Builder withCoordinates(int lat, int lon) {
            this.cityLat = lat;
            this.cityLong = lon;
            return this;
        }

        public Builder withZipCode(int zipCode, String countryCode) {
            this.cityZip = zipCode;
            this.cityZipCountry = countryCode;
            return this;
        }

        public WeatherRequest build() {
            return new WeatherRequest(this);
        }

    }
}
