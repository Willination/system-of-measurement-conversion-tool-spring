package com.example.systemofmeasurementconversiontoolspring.service;

import com.example.systemofmeasurementconversiontoolspring.model.ConversionModel;

public interface ConversionService {
    ConversionModel convertMetricToImperial(ConversionModel input);
    ConversionModel convertImperialToMetric(ConversionModel input);
}
