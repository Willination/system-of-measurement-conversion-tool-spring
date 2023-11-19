package com.example.systemofmeasurementconversiontoolspring;

import com.example.systemofmeasurementconversiontoolspring.service.dto.ConversionModel;
import com.example.systemofmeasurementconversiontoolspring.service.impl.ConversionServiceImpl;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConversionServiceTest {

    private static final double DELTA = 0.001;
    private ConversionModel createConversionModel(String conversionType, String fromUnit, String toUnit, double fromValue) {
        ConversionModel model = new ConversionModel();
        model.setConversionType(conversionType);
        model.setFromUnit(fromUnit);
        model.setToUnit(toUnit);
        model.setFromValue(fromValue);
        return model;
    }

    ConversionServiceImpl conversionService = new ConversionServiceImpl();

    @Test
    public void testConvertMetricToImperialTemperature() {
        ConversionModel result;

        // Celsius to Fahrenheit
        result = conversionService.convertMetricToImperial(createConversionModel("Temperature", "Celsius", "Fahrenheit", 100.0));
        assertEquals(212.0, result.getToValue(), DELTA, "Failed for Temperature - Celsius to Fahrenheit. Expected: 212.0, Actual: " + result.getToValue());

        // Celsius to Kelvin
        result = conversionService.convertMetricToImperial(createConversionModel("Temperature", "Celsius", "Kelvin", 100.0));
        assertEquals(373.15, result.getToValue(), DELTA, "Failed for Temperature - Celsius to Kelvin. Expected: 373.15, Actual: " + result.getToValue());

        // Kelvin to Celsius
        result = conversionService.convertMetricToImperial(createConversionModel("Temperature", "Kelvin", "Celsius", 100.0));
        assertEquals(-173.15, result.getToValue(), DELTA, "Failed for Temperature - Kelvin to Celsius. Expected: -173.15, Actual: " + result.getToValue());

        // Kelvin to Fahrenheit
        result = conversionService.convertMetricToImperial(createConversionModel("Temperature", "Kelvin", "Fahrenheit", 100.0));
        assertEquals(-279.67, result.getToValue(), DELTA, "Failed for Temperature - Kelvin to Fahrenheit. Expected: -279.67, Actual: " + result.getToValue());

        // Fahrenheit to Celsius
        result = conversionService.convertMetricToImperial(createConversionModel("Temperature", "Fahrenheit", "Celsius", 212.0));
        assertEquals(100.0, result.getToValue(), DELTA, "Failed for Temperature - Fahrenheit to Celsius. Expected: 100.0, Actual: " + result.getToValue());

        // Fahrenheit to Kelvin
        result = conversionService.convertMetricToImperial(createConversionModel("Temperature", "Fahrenheit", "Kelvin", 212.0));
        assertEquals(373.15, result.getToValue(), DELTA, "Failed for Temperature - Fahrenheit to Kelvin. Expected: 373.15, Actual: " + result.getToValue());
    }

    @Test
    public void testConvertMetricToImperialLength() {
        ConversionModel result;

        // Centimeters to Inches
        result = conversionService.convertMetricToImperial(createConversionModel("Length", "Centimeters", "Inches", 100.0));
        assertEquals(39.3701, result.getToValue(), DELTA, "Failed for Length - Centimeters to Inches. Expected: 39.3701, Actual: " + result.getToValue());

        // Centimeters to Feet
        result = conversionService.convertMetricToImperial(createConversionModel("Length", "Centimeters", "Feet", 100.0));
        assertEquals(3.2808398950131235, result.getToValue(), DELTA, "Failed for Length - Centimeters to Feet. Expected: 3.2808398950131235, Actual: " + result.getToValue());

        // Centimeters to Yards
        result = conversionService.convertMetricToImperial(createConversionModel("Length", "Centimeters", "Yards", 100.0));
        assertEquals(1.0936132983377078, result.getToValue(), DELTA, "Failed for Length - Centimeters to Yards. Expected: 1.0936132983377078, Actual: " + result.getToValue());

        // Centimeters to Miles
        result = conversionService.convertMetricToImperial(createConversionModel("Length", "Centimeters", "Miles", 100000.0));
        assertEquals(0.24463425196850394, result.getToValue(), DELTA, "Failed for Length - Centimeters to Miles. Expected: 0.24463425196850394, Actual: " + result.getToValue());

        // Meters to Inches
        result = conversionService.convertMetricToImperial(createConversionModel("Length", "Meters", "Inches", 1.0));
        assertEquals(39.3701, result.getToValue(), DELTA, "Failed for Length - Meters to Inches. Expected: 39.3701, Actual: " + result.getToValue());

        // Millimeters to Inches
        result = conversionService.convertMetricToImperial(createConversionModel("Length", "Millimeters", "Inches", 1000.0));
        assertEquals(39.3701, result.getToValue(), DELTA, "Failed for Length - Millimeters to Inches. Expected: 39.3701, Actual: " + result.getToValue());

        // Kilometers to Inches
        result = conversionService.convertMetricToImperial(createConversionModel("Length", "Kilometers", "Inches", 0.001));
        assertEquals(39.3701, result.getToValue(), DELTA, "Failed for Length - Kilometers to Inches. Expected: 39.3701, Actual: " + result.getToValue());

    }

    @Test
    public void testConvertMetricToImperialWeight() {
        ConversionModel result;

        // Kilograms to Pounds
        result = conversionService.convertMetricToImperial(createConversionModel("Weight", "Kilograms", "Pounds", 100.0));
        assertEquals(220.462, result.getToValue(), DELTA, "Failed for Weight - Kilograms to Pounds. Expected: 220.462, Actual: " + result.getToValue());

        // Kilograms to Ounces
        result = conversionService.convertMetricToImperial(createConversionModel("Weight", "Kilograms", "Ounces", 100.0));
        assertEquals(3527.396, result.getToValue(), DELTA, "Failed for Weight - Kilograms to Ounces. Expected: 3527.396, Actual: " + result.getToValue());

        // Kilograms to US Short Tons
        result = conversionService.convertMetricToImperial(createConversionModel("Weight", "Kilograms", "US Short Tons", 100.0));
        assertEquals(0.0984207, result.getToValue(), DELTA, "Failed for Weight - Kilograms to US Short Tons. Expected: 0.0984207, Actual: " + result.getToValue());

        // Grams to Pounds
        result = conversionService.convertMetricToImperial(createConversionModel("Weight", "Grams", "Pounds", 1000.0));
        assertEquals(2.20462, result.getToValue(), DELTA, "Failed for Weight - Grams to Pounds. Expected: 2.20462, Actual: " + result.getToValue());

        // Grams to Ounces
        result = conversionService.convertMetricToImperial(createConversionModel("Weight", "Grams", "Ounces", 1000.0));
        assertEquals(35.27396, result.getToValue(), DELTA, "Failed for Weight - Grams to Ounces. Expected: 35.27396, Actual: " + result.getToValue());

        // Grams to US Short Tons
        result = conversionService.convertMetricToImperial(createConversionModel("Weight", "Grams", "US Short Tons", 1000.0));
        assertEquals(0.00110231, result.getToValue(), DELTA, "Failed for Weight - Grams to US Short Tons. Expected: 0.00110231, Actual: " + result.getToValue());

        // Metric Tons to Pounds
        result = conversionService.convertMetricToImperial(createConversionModel("Weight", "Metric Tons", "Pounds", 1.0));
        assertEquals(2204.62, result.getToValue(), DELTA, "Failed for Weight - Metric Tons to Pounds. Expected: 2204.62, Actual: " + result.getToValue());

        // Metric Tons to Ounces
        result = conversionService.convertMetricToImperial(createConversionModel("Weight", "Metric Tons", "Ounces", 1.0));
        assertEquals(35273.96, result.getToValue(), DELTA, "Failed for Weight - Metric Tons to Ounces. Expected: 35273.96, Actual: " + result.getToValue());

        // Metric Tons to US Short Tons
        result = conversionService.convertMetricToImperial(createConversionModel("Weight", "Metric Tons", "US Short Tons", 1.0));
        assertEquals(0.984207, result.getToValue(), DELTA, "Failed for Weight - Metric Tons to US Short Tons. Expected: 0.984207, Actual: " + result.getToValue());

        // Grams to Kilograms
        result = conversionService.convertMetricToImperial(createConversionModel("Weight", "Grams", "Kilograms", 1000.0));
        assertEquals(1.0, result.getToValue(), DELTA, "Failed for Weight - Grams to Kilograms. Expected: 1.0, Actual: " + result.getToValue());

        // Decigrams to Pounds
        result = conversionService.convertMetricToImperial(createConversionModel("Weight", "Decigrams", "Pounds", 100.0));
        assertEquals(0.0220462, result.getToValue(), DELTA, "Failed for Weight - Decigrams to Pounds. Expected: 0.0220462, Actual: " + result.getToValue());
    }

    @Test
    public void testConvertImperialToMetricTemperature() {
        ConversionModel result;

        // Fahrenheit to Celsius
        result = conversionService.convertImperialToMetric(createConversionModel("Temperature", "Fahrenheit", "Celsius", 212.0));
        assertEquals(100.0, result.getToValue(), DELTA, "Failed for Temperature - Fahrenheit to Celsius. Expected: 100.0, Actual: " + result.getToValue());

        // Fahrenheit to Kelvin
        result = conversionService.convertImperialToMetric(createConversionModel("Temperature", "Fahrenheit", "Kelvin", 212.0));
        assertEquals(373.15, result.getToValue(), DELTA, "Failed for Temperature - Fahrenheit to Kelvin. Expected: 373.15, Actual: " + result.getToValue());
    }

    @Test
    public void testConvertImperialToMetricLength() {
        ConversionModel result;

        // Inches to Centimeters
        result = conversionService.convertImperialToMetric(createConversionModel("Length", "Inches", "Centimeters", 100.0));
        assertEquals(254.0, result.getToValue(), DELTA, "Failed for Length - Inches to Centimeters. Expected: 254.0, Actual: " + result.getToValue());

        // Feet to Centimeters
        result = conversionService.convertImperialToMetric(createConversionModel("Length", "Feet", "Centimeters", 100.0));
        assertEquals(3048.0, result.getToValue(), DELTA, "Failed for Length - Feet to Centimeters. Expected: 3048.0, Actual: " + result.getToValue());

        // Yards to Centimeters
        result = conversionService.convertImperialToMetric(createConversionModel("Length", "Yards", "Centimeters", 100.0));
        assertEquals(9144.0, result.getToValue(), DELTA, "Failed for Length - Yards to Centimeters. Expected: 9144.0, Actual: " + result.getToValue());

        // Miles to Centimeters
        result = conversionService.convertImperialToMetric(createConversionModel("Length", "Miles", "Centimeters", 1.0));
        assertEquals(160934.0, result.getToValue(), DELTA, "Failed for Length - Miles to Centimeters. Expected: 160934.0, Actual: " + result.getToValue());

        // Feet to Meters
        result = conversionService.convertImperialToMetric(createConversionModel("Length", "Feet", "Meters", 100.0));
        assertEquals(30.48, result.getToValue(), DELTA, "Failed for Length - Feet to Meters. Expected: 30.48, Actual: " + result.getToValue());

        // Yards to Meters
        result = conversionService.convertImperialToMetric(createConversionModel("Length", "Yards", "Meters", 100.0));
        assertEquals(91.44, result.getToValue(), DELTA, "Failed for Length - Yards to Meters. Expected: 91.44, Actual: " + result.getToValue());

        // Miles to Meters
        result = conversionService.convertImperialToMetric(createConversionModel("Length", "Miles", "Meters", 1.0));
        assertEquals(1609.34, result.getToValue(), DELTA, "Failed for Length - Miles to Meters. Expected: 1609.34, Actual: " + result.getToValue());
    }

    @Test
    public void testConvertImperialToMetricWeight() {
        ConversionModel result;

        // Pounds to Kilograms
        result = conversionService.convertImperialToMetric(createConversionModel("Weight", "Pounds", "Kilograms", 100.0));
        assertEquals(45.3592, result.getToValue(), DELTA, "Failed for Weight - Pounds to Kilograms. Expected: 45.3592, Actual: " + result.getToValue());

        // Pounds to Grams
        result = conversionService.convertImperialToMetric(createConversionModel("Weight", "Pounds", "Grams", 100.0));
        assertEquals(45359.2, result.getToValue(), DELTA, "Failed for Weight - Pounds to Grams. Expected: 45359.2, Actual: " + result.getToValue());

        // Pounds to Metric Tons
        result = conversionService.convertImperialToMetric(createConversionModel("Weight", "Pounds", "Metric Tons", 100.0));
        assertEquals(0.0453592, result.getToValue(), DELTA, "Failed for Weight - Pounds to Metric Tons. Expected: 0.0453592, Actual: " + result.getToValue());

        // Ounces to Kilograms
        result = conversionService.convertImperialToMetric(createConversionModel("Weight", "Ounces", "Kilograms", 100.0));
        assertEquals(2.83495, result.getToValue(), DELTA, "Failed for Weight - Ounces to Kilograms. Expected: 2.83495, Actual: " + result.getToValue());

        // Ounces to Grams
        result = conversionService.convertImperialToMetric(createConversionModel("Weight", "Ounces", "Grams", 100.0));
        assertEquals(2834.95, result.getToValue(), DELTA, "Failed for Weight - Ounces to Grams. Expected: 2834.95, Actual: " + result.getToValue());

        // Ounces to Metric Tons
        result = conversionService.convertImperialToMetric(createConversionModel("Weight", "Ounces", "Metric Tons", 100.0));
        assertEquals(0.00283495, result.getToValue(), DELTA, "Failed for Weight - Ounces to Metric Tons. Expected: 0.00283495, Actual: " + result.getToValue());

        // US Short Tons to Kilograms
        result = conversionService.convertImperialToMetric(createConversionModel("Weight", "US Short Tons", "Kilograms", 1.0));
        assertEquals(907.185, result.getToValue(), DELTA, "Failed for Weight - US Short Tons to Kilograms. Expected: 907.185, Actual: " + result.getToValue());

        // US Short Tons to Grams
        result = conversionService.convertImperialToMetric(createConversionModel("Weight", "US Short Tons", "Grams", 1.0));
        assertEquals(907185.0, result.getToValue(), DELTA, "Failed for Weight - US Short Tons to Grams. Expected: 907185.0, Actual: " + result.getToValue());

        // US Short Tons to Metric Tons
        result = conversionService.convertImperialToMetric(createConversionModel("Weight", "US Short Tons", "Metric Tons", 1.0));
        assertEquals(0.907185, result.getToValue(), DELTA, "Failed for Weight - US Short Tons to Metric Tons. Expected: 0.907185, Actual: " + result.getToValue());
    }

}