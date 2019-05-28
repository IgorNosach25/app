package com.nosach.app.models.requests;

import lombok.Data;

@Data
public class ScheduleRequest {
    private int id;
    private boolean isAvailable;
    private String from;
    private String to;
    private int businessId;
}
