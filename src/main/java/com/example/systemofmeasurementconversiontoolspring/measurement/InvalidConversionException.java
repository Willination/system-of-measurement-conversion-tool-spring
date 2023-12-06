package com.example.systemofmeasurementconversiontoolspring.measurement;

public class InvalidConversionException extends RuntimeException {
    public InvalidConversionException(String message) {
        super(message);
    }
}