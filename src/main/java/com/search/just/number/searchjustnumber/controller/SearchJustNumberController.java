package com.search.just.number.searchjustnumber.controller;

import com.search.just.number.searchjustnumber.service.SearchJustNumberService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/")
public class SearchJustNumberController {

    private final SearchJustNumberService service;

    public SearchJustNumberController(SearchJustNumberService service) {
        this.service = service;
    }

    @GetMapping("/{number}")
    public Map<String, Integer> getNearestNumber(@PathVariable("number") int number) {
        int nearestNumber = service.returnedNumberClosestLeft(number);
        return Map.of("prime-number", nearestNumber, "requested-x", number);
    }

}
