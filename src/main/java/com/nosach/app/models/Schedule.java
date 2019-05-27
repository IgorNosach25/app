package com.nosach.app.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Schedule {
    private int id;
    private boolean isAvailable;
    private LocalDate from;
    private LocalDate to;
    private Business business;
}
