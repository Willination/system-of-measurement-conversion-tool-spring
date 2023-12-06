package com.example.systemofmeasurementconversiontoolspring.service.measurement;

public enum ConversionType {
    TEMPERATURE("Temperature"),
    LENGTH("Length"),
    WEIGHT("Weight");

    private final String type;

    ConversionType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}