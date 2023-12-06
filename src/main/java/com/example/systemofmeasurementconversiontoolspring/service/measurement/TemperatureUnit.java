package com.example.systemofmeasurementconversiontoolspring.service.measurement;

public enum TemperatureUnit {
    CELSIUS("Celsius"),
    FAHRENHEIT("Fahrenheit"),
    KELVIN("Kelvin");

    private final String stringValue;

    TemperatureUnit(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}