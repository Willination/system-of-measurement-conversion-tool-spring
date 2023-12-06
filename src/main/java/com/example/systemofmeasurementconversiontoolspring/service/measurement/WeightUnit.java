package com.example.systemofmeasurementconversiontoolspring.service.measurement;

public enum WeightUnit {
    KILOGRAMS("Kilograms"),
    GRAMS("Grams"),
    METRIC_TONS("Metric Tons"),
    POUNDS("Pounds"),
    OUNCES("Ounces"),
    US_SHORT_TONS("US Short Tons"),
    MILLIGRAMS("Milligrams"),
    DECIGRAMS("Decigrams");

    private final String unit;

    WeightUnit(String unit) {
        this.unit = unit;
    }

    public String getString() {
        return unit;
    }
}