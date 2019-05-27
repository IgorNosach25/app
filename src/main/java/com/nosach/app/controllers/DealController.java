package com.nosach.app.controllers;

import com.nosach.app.deal.DealProcessor;
import com.nosach.app.models.requests.DealRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "deals")
public class DealController {

    private DealProcessor dealProcessor;

    @Autowired
    public DealController(DealProcessor dealProcessor) {
        this.dealProcessor = dealProcessor;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "/process")
    public void processDeal(@RequestBody DealRequest dealRequest) {
        dealProcessor.processDeal(dealRequest);
    }
}
