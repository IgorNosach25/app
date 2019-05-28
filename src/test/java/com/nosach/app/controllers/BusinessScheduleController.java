package com.nosach.app.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nosach.app.business.ScheduleService;
import com.nosach.app.models.requests.ScheduleRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BusinessScheduleController {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;
    @MockBean
    private ScheduleService scheduleService;
    private ScheduleRequest schedule;

    @Before
    public void setUp() {
        this.schedule = new ScheduleRequest();
        schedule.setFrom(LocalDate.of(2019, 12, 11).toString());
        schedule.setTo(LocalDate.of(2019, 12, 12).toString());
        schedule.setAvailable(true);
    }

    @Test
    public void createScheduleOfBusinessShouldReturnStatusCreated() throws Exception {
        mockMvc
                .perform(post("/businesses/schedules")
                        .content(mapper.writeValueAsString(this.schedule))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

}
