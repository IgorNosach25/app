package com.nosach.app.controllers.business;

import com.nosach.app.business.ScheduleService;
import com.nosach.app.models.requests.ScheduleRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "businesses/schedules")
public class BusinessScheduleController {

    private final ScheduleService scheduledService;

    public BusinessScheduleController(ScheduleService scheduledService) {
        this.scheduledService = scheduledService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void publishSchedule(@RequestBody ScheduleRequest scheduleRequest){
        scheduledService.create(scheduleRequest);
    }
}
