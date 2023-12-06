package com.example.systemofmeasurementconversiontoolspring.service.impl;

import com.example.systemofmeasurementconversiontoolspring.service.ConversionService;
import com.example.systemofmeasurementconversiontoolspring.service.dto.ConversionModel;
import com.example.systemofmeasurementconversiontoolspring.service.measurement.InvalidConversionException;
import com.example.systemofmeasurementconversiontoolspring.service.measurement.LengthUnit;
import com.example.systemofmeasurementconversiontoolspring.service.measurement.TemperatureUnit;
import com.example.systemofmeasurementconversiontoolspring.service.measurement.WeightUnit;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ConversionServiceImpl implements ConversionService {

    @Override
    public ConversionModel convertMetricToImperial(ConversionModel input) {
        if (input.getConversionType() == null) {
            throw new InvalidConversionException("Conversion type for Metric-to-Imperial  is null");
        }

        switch (input.getConversionType()) {
            case TEMPERATURE -> convertTemperatureMetricToImperial(input);
            case LENGTH -> convertLengthMetricToImperial(input);
            case WEIGHT -> convertWeightMetricToImperial(input);
            default ->
                    throw new InvalidConversionException("Invalid conversion type: " + input.getConversionType());
        }
        return input;


    }

    @Override
    public ConversionModel convertImperialToMetric(ConversionModel input) {
        if (input.getConversionType() == null) {
            throw new InvalidConversionException("Conversion type for Imperial-to-Metric  is null");
        }

        switch (input.getConversionType()) {
            case TEMPERATURE -> convertTemperatureImperialToMetric(input);
            case LENGTH -> convertLengthImperialToMetric(input);
            case WEIGHT -> convertWeightImperialToMetric(input);
            default ->
                    throw new InvalidConversionException("Invalid conversion type: " + input.getConversionType());
        }
        return input;
    }

    private void convertTemperatureMetricToImperial(ConversionModel input) {
        if (TemperatureUnit.CELSIUS.getStringValue().equals(input.getFromUnit()) && TemperatureUnit.FAHRENHEIT.getStringValue().equals(input.getToUnit())) {
            input.setToValue((input.getFromValue() * 9 / 5) + 32);
        } else if (TemperatureUnit.CELSIUS.getStringValue().equals(input.getFromUnit()) && TemperatureUnit.KELVIN.getStringValue().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() + 273.15);
        } else if (TemperatureUnit.KELVIN.getStringValue().equals(input.getFromUnit()) && TemperatureUnit.CELSIUS.getStringValue().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() - 273.15);
        } else if (TemperatureUnit.KELVIN.getStringValue().equals(input.getFromUnit()) && TemperatureUnit.FAHRENHEIT.getStringValue().equals(input.getToUnit())) {
            input.setToValue((input.getFromValue() - 273.15) * 9 / 5 + 32);
        } else if (TemperatureUnit.FAHRENHEIT.getStringValue().equals(input.getFromUnit()) && TemperatureUnit.CELSIUS.getStringValue().equals(input.getToUnit())) {
            input.setToValue((input.getFromValue() - 32) * 5 / 9);
        } else if (TemperatureUnit.FAHRENHEIT.getStringValue().equals(input.getFromUnit()) && TemperatureUnit.KELVIN.getStringValue().equals(input.getToUnit())) {
            input.setToValue((input.getFromValue() - 32) * 5 / 9 + 273.15);
        }
        getRoundedValue(input);
    }

    private void convertLengthMetricToImperial(ConversionModel input) {
        if (LengthUnit.CENTIMETERS.getString().equals(input.getFromUnit()) && LengthUnit.INCHES.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() / 2.54);
        } else if (LengthUnit.CENTIMETERS.getString().equals(input.getFromUnit()) && LengthUnit.FEET.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() / (2.54 * 12));
        } else if (LengthUnit.CENTIMETERS.getString().equals(input.getFromUnit()) && LengthUnit.YARDS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() / (2.54 * 36));
        } else if (LengthUnit.CENTIMETERS.getString().equals(input.getFromUnit()) && LengthUnit.MILES.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() / (2.54 * 100000) * 0.621371);
        } else if (LengthUnit.METERS.getString().equals(input.getFromUnit()) && LengthUnit.INCHES.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 39.3701);
        } else if (LengthUnit.METERS.getString().equals(input.getFromUnit()) && LengthUnit.FEET.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 3.28084);
        } else if (LengthUnit.METERS.getString().equals(input.getFromUnit()) && LengthUnit.YARDS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 1.09361);
        } else if (LengthUnit.METERS.getString().equals(input.getFromUnit()) && LengthUnit.MILES.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() / 1609.34);
        } else if (LengthUnit.KILOMETERS.getString().equals(input.getFromUnit()) && LengthUnit.INCHES.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 39370.1);
        } else if (LengthUnit.KILOMETERS.getString().equals(input.getFromUnit()) && LengthUnit.FEET.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 3280.84);
        } else if (LengthUnit.KILOMETERS.getString().equals(input.getFromUnit()) && LengthUnit.YARDS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 1094);
        } else if (LengthUnit.KILOMETERS.getString().equals(input.getFromUnit()) && LengthUnit.MILES.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() / 1.60934);
        } else if (LengthUnit.MILLIMETERS.getString().equals(input.getFromUnit()) && LengthUnit.INCHES.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() / 25.4);
        } else if (LengthUnit.MILLIMETERS.getString().equals(input.getFromUnit()) && LengthUnit.FEET.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() / 304.8);
        } else if (LengthUnit.MILLIMETERS.getString().equals(input.getFromUnit()) && LengthUnit.YARDS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() / 914.4);
        } else if (LengthUnit.MILLIMETERS.getString().equals(input.getFromUnit()) && LengthUnit.MILES.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() / 1609344.0);
        }
        getRoundedValue(input);
    }

    private void convertWeightMetricToImperial(ConversionModel input) {
        if (WeightUnit.KILOGRAMS.getString().equals(input.getFromUnit()) && WeightUnit.POUNDS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 2.20462);
        } else if (WeightUnit.KILOGRAMS.getString().equals(input.getFromUnit()) && WeightUnit.OUNCES.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 35.27396);
        } else if (WeightUnit.KILOGRAMS.getString().equals(input.getFromUnit()) && WeightUnit.US_SHORT_TONS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.000984207);
        } else if (WeightUnit.GRAMS.getString().equals(input.getFromUnit()) && WeightUnit.POUNDS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.00220462);
        } else if (WeightUnit.GRAMS.getString().equals(input.getFromUnit()) && WeightUnit.OUNCES.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.03527396);
        } else if (WeightUnit.GRAMS.getString().equals(input.getFromUnit()) && WeightUnit.US_SHORT_TONS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 1.10231e-6);
        } else if (WeightUnit.METRIC_TONS.getString().equals(input.getFromUnit()) && WeightUnit.POUNDS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 2204.62);
        } else if (WeightUnit.METRIC_TONS.getString().equals(input.getFromUnit()) && WeightUnit.OUNCES.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 35273.96);
        } else if (WeightUnit.METRIC_TONS.getString().equals(input.getFromUnit()) && WeightUnit.US_SHORT_TONS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.984207);
        } else if (WeightUnit.GRAMS.getString().equals(input.getFromUnit()) && WeightUnit.KILOGRAMS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() / 1000);
        } else if (WeightUnit.DECIGRAMS.getString().equals(input.getFromUnit()) && WeightUnit.POUNDS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.000220462);
        } else if (WeightUnit.MILLIGRAMS.getString().equals(input.getFromUnit()) && WeightUnit.POUNDS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 2.20462e-6);
        } else if (WeightUnit.MILLIGRAMS.getString().equals(input.getFromUnit()) && WeightUnit.OUNCES.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 3.5274e-5);
        } else if (WeightUnit.MILLIGRAMS.getString().equals(input.getFromUnit()) && WeightUnit.US_SHORT_TONS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 9.8421e-10);
        }
        getRoundedValue(input);
    }

    private void convertTemperatureImperialToMetric(ConversionModel input) {
        if (TemperatureUnit.FAHRENHEIT.getStringValue().equals(input.getFromUnit()) && TemperatureUnit.CELSIUS.getStringValue().equals(input.getToUnit())) {
            input.setToValue((input.getFromValue() - 32) * 5 / 9);
        } else if (TemperatureUnit.FAHRENHEIT.getStringValue().equals(input.getFromUnit()) && TemperatureUnit.KELVIN.getStringValue().equals(input.getToUnit())) {
            input.setToValue((input.getFromValue() - 32) * 5 / 9 + 273.15);
        } else if (TemperatureUnit.KELVIN.getStringValue().equals(input.getFromUnit()) && TemperatureUnit.CELSIUS.getStringValue().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() - 273.15);
        } else if (TemperatureUnit.KELVIN.getStringValue().equals(input.getFromUnit()) && TemperatureUnit.FAHRENHEIT.getStringValue().equals(input.getToUnit())) {
            input.setToValue((input.getFromValue() - 273.15) * 9 / 5 + 32);
        } else if (TemperatureUnit.CELSIUS.getStringValue().equals(input.getFromUnit()) && TemperatureUnit.FAHRENHEIT.getStringValue().equals(input.getToUnit())) {
            input.setToValue((input.getFromValue() * 9 / 5) + 32);
        } else if (TemperatureUnit.CELSIUS.getStringValue().equals(input.getFromUnit()) && TemperatureUnit.KELVIN.getStringValue().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() + 273.15);
        }
        getRoundedValue(input);
    }

    private void convertLengthImperialToMetric(ConversionModel input) {
        if (LengthUnit.INCHES.getString().equals(input.getFromUnit()) && LengthUnit.CENTIMETERS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 2.54);
        } else if (LengthUnit.INCHES.getString().equals(input.getFromUnit()) && LengthUnit.FEET.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.0833333);
        } else if (LengthUnit.INCHES.getString().equals(input.getFromUnit()) && LengthUnit.YARDS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.0277778);
        } else if (LengthUnit.INCHES.getString().equals(input.getFromUnit()) && LengthUnit.MILES.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 2.54 / 100000 / 0.000621371);
        } else if (LengthUnit.FEET.getString().equals(input.getFromUnit()) && LengthUnit.CENTIMETERS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 30.48);
        } else if (LengthUnit.FEET.getString().equals(input.getFromUnit()) && LengthUnit.YARDS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() / 3);
        } else if (LengthUnit.FEET.getString().equals(input.getFromUnit()) && LengthUnit.MILES.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 2.54 / 100000 / 0.000621371 / 5280);
        } else if (LengthUnit.YARDS.getString().equals(input.getFromUnit()) && LengthUnit.CENTIMETERS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 91.44);
        } else if (LengthUnit.YARDS.getString().equals(input.getFromUnit()) && LengthUnit.METERS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.9144);
        } else if (LengthUnit.YARDS.getString().equals(input.getFromUnit()) && LengthUnit.KILOMETERS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.0009144);
        } else if (LengthUnit.MILES.getString().equals(input.getFromUnit()) && LengthUnit.CENTIMETERS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 160934.0);
        } else if (LengthUnit.MILES.getString().equals(input.getFromUnit()) && LengthUnit.METERS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 1609.34);
        } else if (LengthUnit.MILES.getString().equals(input.getFromUnit()) && LengthUnit.KILOMETERS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 1.60934);
        } else if (LengthUnit.MILES.getString().equals(input.getFromUnit()) && LengthUnit.MILLIMETERS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 1609340.0);
        } else if (LengthUnit.FEET.getString().equals(input.getFromUnit()) && LengthUnit.KILOMETERS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.0003048);
        } else if (LengthUnit.FEET.getString().equals(input.getFromUnit()) && LengthUnit.METERS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.3048);
        } else if (LengthUnit.INCHES.getString().equals(input.getFromUnit()) && LengthUnit.MILLIMETERS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 25.4);
        } else if (LengthUnit.INCHES.getString().equals(input.getFromUnit()) && LengthUnit.METERS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.0254);
        } else if (LengthUnit.INCHES.getString().equals(input.getFromUnit()) && LengthUnit.KILOMETERS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 2.54e-5);
        } else if (LengthUnit.FEET.getString().equals(input.getFromUnit()) && LengthUnit.MILLIMETERS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 304.8);
        } else if (LengthUnit.YARDS.getString().equals(input.getFromUnit()) && LengthUnit.MILLIMETERS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 914.4);
        }

        getRoundedValue(input);
    }

    private void convertWeightImperialToMetric(ConversionModel input) {
        if (WeightUnit.POUNDS.getString().equals(input.getFromUnit()) && WeightUnit.KILOGRAMS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.453592);
        } else if (WeightUnit.POUNDS.getString().equals(input.getFromUnit()) && WeightUnit.GRAMS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 453.592);
        } else if (WeightUnit.POUNDS.getString().equals(input.getFromUnit()) && WeightUnit.METRIC_TONS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.000453592);
        } else if (WeightUnit.OUNCES.getString().equals(input.getFromUnit()) && WeightUnit.KILOGRAMS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.0283495);
        } else if (WeightUnit.OUNCES.getString().equals(input.getFromUnit()) && WeightUnit.GRAMS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 28.3495);
        } else if (WeightUnit.OUNCES.getString().equals(input.getFromUnit()) && WeightUnit.METRIC_TONS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 2.83495e-5);
        } else if (WeightUnit.US_SHORT_TONS.getString().equals(input.getFromUnit()) && WeightUnit.KILOGRAMS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 907.185);
        } else if (WeightUnit.US_SHORT_TONS.getString().equals(input.getFromUnit()) && WeightUnit.GRAMS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 907185);
        } else if (WeightUnit.US_SHORT_TONS.getString().equals(input.getFromUnit()) && WeightUnit.METRIC_TONS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 0.907185);
        } else if (WeightUnit.OUNCES.getString().equals(input.getFromUnit()) && WeightUnit.MILLIGRAMS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 28349.5);
        } else if (WeightUnit.POUNDS.getString().equals(input.getFromUnit()) && WeightUnit.MILLIGRAMS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 453592);
        } else if (WeightUnit.US_SHORT_TONS.getString().equals(input.getFromUnit()) && WeightUnit.MILLIGRAMS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 907185000);
        } else if (WeightUnit.OUNCES.getString().equals(input.getFromUnit()) && WeightUnit.DECIGRAMS.getString().equals(input.getToUnit())) {
            input.setToValue(input.getFromValue() * 28.3495);
        }

        getRoundedValue(input);
    }

    private void getRoundedValue(ConversionModel model)
    {
        BigDecimal roundedValue = BigDecimal.valueOf(model.getToValue()).setScale(5, RoundingMode.HALF_UP);
        model.setToValue(roundedValue.doubleValue());
    }
}
