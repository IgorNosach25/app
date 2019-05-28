package com.nosach.app.models.requests;


import lombok.Data;

@Data
public class DealRequest {
    private int clientId;
    private int businessId;
    private int scheduleId;
    private String message;
}
