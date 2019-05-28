package com.nosach.app.controllers.business;

import com.nosach.app.business.BusinessService;
import com.nosach.app.models.requests.BusinessRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "businesses")
public class BusinessController {

    private BusinessService businessService;

    @Autowired
    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createBusiness(@RequestBody BusinessRequest businessRequest){
        businessService.create(businessRequest);
    }
}
