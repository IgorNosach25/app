package com.nosach.app.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nosach.app.deal.DealProcessor;
import com.nosach.app.models.requests.DealRequest;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DealControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    private DealRequest dealRequest;

    @MockBean
    private DealProcessor dealProcessor;

    @Before
    public void setUp() {
        this.dealRequest = new DealRequest();
        dealRequest.setClientId(1);
        dealRequest.setBusinessId(1);
    }

    @Test
    public void clientShouldSendRequestForBookingScheduleOfBusiness() throws Exception {
        this.mockMvc
                .perform(post("/deals/process")
                        .content(mapper.writeValueAsString(this.dealRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
