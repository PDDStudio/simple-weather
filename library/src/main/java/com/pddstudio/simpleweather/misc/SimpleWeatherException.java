package com.pddstudio.simpleweather.misc;

/**
 * This Class was created by Patrick J
 * on 26.01.16. For more Details and Licensing
 * have a look at the README.md
 */
public class SimpleWeatherException extends Exception {

    public SimpleWeatherException() {
        super("Failed to execute. [NO DESCRIPTION GIVEN]");
    }

    public SimpleWeatherException(String message) {
        super(message);
    }

}
