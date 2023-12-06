package com.example.systemofmeasurementconversiontoolspring.controller;

import com.example.systemofmeasurementconversiontoolspring.service.ConversionService;
import com.example.systemofmeasurementconversiontoolspring.model.ConversionModel;
import com.example.systemofmeasurementconversiontoolspring.measurement.ErrorResponse;
import com.example.systemofmeasurementconversiontoolspring.measurement.InvalidConversionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/conversion")
@CrossOrigin("*")
public class ConversionController {

    private final ConversionService conversionService;

    public ConversionController(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @PostMapping("/metric-to-imperial")
    public ResponseEntity<?> convertMetricToImperial(@RequestBody ConversionModel input) {
        try {
            ConversionModel result = conversionService.convertMetricToImperial(input);
            return ResponseEntity.ok(result);
        } catch (InvalidConversionException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error"));
        }
    }

    @PostMapping("/imperial-to-metric")
    public ResponseEntity<?> convertImperialToMetric(@RequestBody ConversionModel input) {
        try {
            ConversionModel result = conversionService.convertImperialToMetric(input);
            return ResponseEntity.ok(result);
        } catch (InvalidConversionException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error"));
        }
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