package com.example.systemofmeasurementconversiontoolspring.service.measurement;

public class InvalidConversionException extends RuntimeException {
    public InvalidConversionException(String message) {
        super(message);
    }
}