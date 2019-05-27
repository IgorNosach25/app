package com.nosach.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.nosach.app.business.BusinessType;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Business {
    private int  id;
    private String name;
    private BusinessOwner owner;
    private BusinessType businessType;
    private String description;
    private Coordinate location;
    private Schedule schedule;
}
