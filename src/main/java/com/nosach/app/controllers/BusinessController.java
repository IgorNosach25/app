package com.nosach.app.controllers;

import com.nosach.app.business.BusinessService;
import com.nosach.app.models.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "businesses")
public class BusinessController {

    private BusinessService service;

    @Autowired
    public BusinessController(BusinessService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/create")
    public void createBusiness(@RequestBody Business business){
        service.save(business);
    }
}
