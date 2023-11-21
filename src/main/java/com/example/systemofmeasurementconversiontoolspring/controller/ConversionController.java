package com.example.systemofmeasurementconversiontoolspring.controller;

import com.example.systemofmeasurementconversiontoolspring.service.ConversionService;
import com.example.systemofmeasurementconversiontoolspring.service.dto.ConversionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/conversion")
@CrossOrigin("*")
public class ConversionController {

    @Autowired
    private ConversionService conversionService;

    @PostMapping("/metric-to-imperial")
    public ConversionModel convertMetricToImperial(@RequestBody ConversionModel input) {
        return conversionService.convertMetricToImperial(input);
    }

    @PostMapping("/imperial-to-metric")
    public ConversionModel convertImperialToMetric(@RequestBody ConversionModel input) {
        return conversionService.convertImperialToMetric(input);
    }

    @GetMapping("/test")
    public Map<String, String> sayHello() {
        HashMap<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("foo", "bar");
        map.put("aa", "bb");
        return map;
    }
}