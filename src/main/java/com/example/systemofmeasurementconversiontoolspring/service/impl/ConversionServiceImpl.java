package com.example.systemofmeasurementconversiontoolspring.service.impl;

import com.example.systemofmeasurementconversiontoolspring.service.ConversionService;
import com.example.systemofmeasurementconversiontoolspring.service.dto.ConversionModel;
import org.springframework.stereotype.Service;

@Service
public class ConversionServiceImpl implements ConversionService {

    @Override
    public ConversionModel convertMetricToImperial(ConversionModel input) {
        switch (input.getConversionType()) {
            case "Temperature" -> convertTemperatureMetricToImperial(input);
            case "Length" -> convertLengthMetricToImperial(input);
            case "Weight" -> convertWeightMetricToImperial(input);
            default -> {
            }
        }
        return input;
    }

    @Override
    public ConversionModel convertImperialToMetric(ConversionModel input) {
        switch (input.getConversionType()) {
            case "Temperature" -> convertTemperatureImperialToMetric(input);
            case "Length" -> convertLengthImperialToMetric(input);
            case "Weight" -> convertWeightImperialToMetric(input);
            default -> {
            }
        }
        return input;
    }

    private void convertTemperatureMetricToImperial(ConversionModel input) {
        if ("Celsius".equals(input.getFromUnit()) && "Fahrenheit".equals(input.getToUnit())) {
            input.setToValue((input.getFromValue() * 9 / 5) + 32);
        } else if ("Celsius".equals(input.getFromUnit()) && "Kelvin".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() + 273.15);
        } else if ("Kelvin".equals(input.getFromUnit()) && "Celsius".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() - 273.15);
        } else if ("Kelvin".equals(input.getFromUnit()) && "Fahrenheit".equals(input.getToUnit())) {
            input.setToValue((input.getFromValue() - 273.15) * 9 / 5 + 32);
        } else if ("Fahrenheit".equals(input.getFromUnit()) && "Celsius".equals(input.getToUnit())) {
            input.setToValue((input.getFromValue() - 32) * 5 / 9);
        } else if ("Fahrenheit".equals(input.getFromUnit()) && "Kelvin".equals(input.getToUnit())) {
            input.setToValue((input.getFromValue() - 32) * 5 / 9 + 273.15);
        }
    }

    private void convertLengthMetricToImperial(ConversionModel input) {
        if ("Centimeters".equals(input.getFromUnit()) && "Inches".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() / 2.54);
        } else if ("Centimeters".equals(input.getFromUnit()) && "Feet".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() / (2.54 * 12));
        } else if ("Centimeters".equals(input.getFromUnit()) && "Yards".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() / (2.54 * 36));
        } else if ("Centimeters".equals(input.getFromUnit()) && "Miles".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() / (2.54 * 100000) * 0.621371);
        } else if ("Meters".equals(input.getFromUnit()) && "Inches".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 39.3701);
        } else if ("Meters".equals(input.getFromUnit()) && "Feet".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 3.28084);
        } else if ("Meters".equals(input.getFromUnit()) && "Yards".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 1.09361);
        } else if ("Meters".equals(input.getFromUnit()) && "Miles".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() / 1609.34);
        } else if ("Kilometers".equals(input.getFromUnit()) && "Inches".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 39370.1);
        } else if ("Kilometers".equals(input.getFromUnit()) && "Feet".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 3280.84);
        } else if ("Kilometers".equals(input.getFromUnit()) && "Yards".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 1094);
        } else if ("Kilometers".equals(input.getFromUnit()) && "Miles".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() / 1.60934);
        } else if ("Millimeters".equals(input.getFromUnit()) && "Inches".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() / 25.4);
        }
    }

    private void convertWeightMetricToImperial(ConversionModel input) {
        if ("Kilograms".equals(input.getFromUnit()) && "Pounds".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 2.20462);
        } else if ("Kilograms".equals(input.getFromUnit()) && "Ounces".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 35.27396);
        } else if ("Kilograms".equals(input.getFromUnit()) && "US Short Tons".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.000984207);
        } else if ("Grams".equals(input.getFromUnit()) && "Pounds".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.00220462);
        } else if ("Grams".equals(input.getFromUnit()) && "Ounces".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.03527396);
        } else if ("Grams".equals(input.getFromUnit()) && "US Short Tons".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 1.10231e-6);
        } else if ("Metric Tons".equals(input.getFromUnit()) && "Pounds".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 2204.62);
        } else if ("Metric Tons".equals(input.getFromUnit()) && "Ounces".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 35273.96);
        } else if ("Metric Tons".equals(input.getFromUnit()) && "US Short Tons".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.984207);
        }
        else if ("Grams".equals(input.getFromUnit()) && "Kilograms".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() / 1000);
        }
        else if ("Decigrams".equals(input.getFromUnit()) && "Pounds".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.000220462);
        }
    }

    private void convertTemperatureImperialToMetric(ConversionModel input) {
        if ("Fahrenheit".equals(input.getFromUnit()) && "Celsius".equals(input.getToUnit())) {
            input.setToValue((input.getFromValue() - 32) * 5 / 9);
        } else if ("Fahrenheit".equals(input.getFromUnit()) && "Kelvin".equals(input.getToUnit())) {
            input.setToValue((input.getFromValue() - 32) * 5 / 9 + 273.15);
        } else if ("Kelvin".equals(input.getFromUnit()) && "Celsius".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() - 273.15);
        } else if ("Kelvin".equals(input.getFromUnit()) && "Fahrenheit".equals(input.getToUnit())) {
            input.setToValue((input.getFromValue() - 273.15) * 9 / 5 + 32);
        } else if ("Celsius".equals(input.getFromUnit()) && "Fahrenheit".equals(input.getToUnit())) {
            input.setToValue((input.getFromValue() * 9 / 5) + 32);
        } else if ("Celsius".equals(input.getFromUnit()) && "Kelvin".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() + 273.15);
        }
    }

    private void convertLengthImperialToMetric(ConversionModel input) {
        if ("Inches".equals(input.getFromUnit()) && "Centimeters".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 2.54);
        } else if ("Inches".equals(input.getFromUnit()) && "Feet".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.0833333);
        } else if ("Inches".equals(input.getFromUnit()) && "Yards".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.0277778);
        } else if ("Inches".equals(input.getFromUnit()) && "Miles".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 2.54 / 100000 / 0.000621371);
        } else if ("Feet".equals(input.getFromUnit()) && "Centimeters".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 30.48);
        } else if ("Feet".equals(input.getFromUnit()) && "Yards".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() / 3);
        } else if ("Feet".equals(input.getFromUnit()) && "Miles".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 2.54 / 100000 / 0.000621371 / 5280);
        } else if ("Yards".equals(input.getFromUnit()) && "Centimeters".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 91.44);
        } else if ("Yards".equals(input.getFromUnit()) && "Meters".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.9144);
        } else if ("Yards".equals(input.getFromUnit()) && "Kilometers".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.0009144);
        } else if ("Miles".equals(input.getFromUnit()) && "Centimeters".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 160934.0);
        } else if ("Miles".equals(input.getFromUnit()) && "Meters".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 1609.34);
        } else if ("Miles".equals(input.getFromUnit()) && "Kilometers".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 1.60934);
        } else if ("Miles".equals(input.getFromUnit()) && "Millimeters".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 1609340.0);
        } else if ("Feet".equals(input.getFromUnit()) && "Kilometers".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.0003048);
        } else if ("Feet".equals(input.getFromUnit()) && "Meters".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.3048);
        }
    }

    private void convertWeightImperialToMetric(ConversionModel input) {
        if ("Pounds".equals(input.getFromUnit()) && "Kilograms".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.453592);
        } else if ("Pounds".equals(input.getFromUnit()) && "Grams".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 453.592);
        } else if ("Pounds".equals(input.getFromUnit()) && "Metric Tons".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.000453592);
        } else if ("Ounces".equals(input.getFromUnit()) && "Kilograms".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.0283495);
        } else if ("Ounces".equals(input.getFromUnit()) && "Grams".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 28.3495);
        } else if ("Ounces".equals(input.getFromUnit()) && "Metric Tons".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 2.83495e-5);
        } else if ("US Short Tons".equals(input.getFromUnit()) && "Kilograms".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 907.185);
        } else if ("US Short Tons".equals(input.getFromUnit()) && "Grams".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 907185);
        } else if ("US Short Tons".equals(input.getFromUnit()) && "Metric Tons".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.907185);
        }
        else if ("Ounces".equals(input.getFromUnit()) && "Milligrams".equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 28349.5);
        }
    }
}
