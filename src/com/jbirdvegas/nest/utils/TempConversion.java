package com.jbirdvegas.nest.utils;

import java.text.DecimalFormat;

/**
 * Created by jbird on 3/13/14.
 */
public class TempConversion {
    /**
     * Possible autoboxing case *
     * Designed to satisfy the formula { °C  x  9/5 + 32 = °F }
     * @param celsius degrees of temperature in Celsius
     * @return degrees in Fahrenheit
     */
    public static int getFahrenheit(double celsius) {
        return (int) Math.round((celsius * 9) / 5) + 32;
    }

    /**
     * Designed to satisfy the formula { °C  x  9/5 + 32 = °F }
     * @param fahrenheit degrees of temperature in Fahrenheit
     * @return degrees in Celsius
     */
    public static double getCelsius(int fahrenheit) {
        double degrees = ((double) fahrenheit - 32) * 5 / 9;
        return Double.valueOf(new DecimalFormat("#0.000000").format(degrees));
    }
}
