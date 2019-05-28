package com.nosach.app.models;

import com.nosach.app.business.BusinessType;
import lombok.Data;

@Data
public class Business {
    private int  id;
    private String name;
    private BusinessOwner owner;
    private BusinessType businessType;
    private String description;
    private Coordinate location;
    private Schedule schedule;
}
