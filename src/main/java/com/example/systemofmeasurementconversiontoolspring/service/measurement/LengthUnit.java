package com.example.systemofmeasurementconversiontoolspring.service.measurement;

public enum LengthUnit {
    CENTIMETERS("Centimeters"),
    METERS("Meters"),
    KILOMETERS("Kilometers"),
    MILLIMETERS("Millimeters"),
    INCHES("Inches"),
    FEET("Feet"),
    YARDS("Yards"),
    MILES("Miles");

    private final String text;

    LengthUnit(String text) {
        this.text = text;
    }

    public String getString() {
        return text;
    }
}
