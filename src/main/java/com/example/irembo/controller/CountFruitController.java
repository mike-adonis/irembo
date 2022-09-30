package com.example.irembo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CountFruitController {

    private final CounterService counterService;

    public CountFruitController(CounterService counterService) {
        this.counterService = counterService;
    }

    @GetMapping("/count")
    public ResponseEntity<String> count(@RequestBody String[] fruits) {
        return new ResponseEntity<>(counterService.count(fruits), HttpStatus.OK);
    }

    @GetMapping("/count-e")
    public ResponseEntity<String> countEnhanced(@RequestBody String[] fruits) {
        return new ResponseEntity<>(counterService.enhancedCount(fruits), HttpStatus.OK);
    }

}
