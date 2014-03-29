package com.jbirdvegas.nest.tests;

import com.jbirdvegas.nest.utils.TempConversion;
import junit.framework.TestCase;

import java.text.DecimalFormat;

/**
 * Created by jbird: 3/17/14
 */
public class TempConversionTest extends TestCase {
    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testGetFahrenheit() throws Exception {
        TestCase.assertEquals(72, TempConversion.getFahrenheit(22.2222));
    }

    public void testGetCelsius() throws Exception {
        double degrees = Double.valueOf(new DecimalFormat("#0.000000").format(65/3d));
        TestCase.assertEquals(degrees, TempConversion.getCelsius(71));
    }
}
