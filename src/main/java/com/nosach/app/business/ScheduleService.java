package com.nosach.app.business;

import com.nosach.app.models.requests.ScheduleRequest;

public interface ScheduleService {
    void create(ScheduleRequest scheduleRequest);
}
