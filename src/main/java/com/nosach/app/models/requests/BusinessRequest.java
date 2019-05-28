package com.nosach.app.models.requests;

import com.nosach.app.business.BusinessType;
import com.nosach.app.models.Coordinate;
import lombok.Data;

@Data
public class BusinessRequest {
    private int id;
    private String name;
    private int ownerId;
    private BusinessType businessType;
    private String description;
    private Coordinate coordinate;
}
