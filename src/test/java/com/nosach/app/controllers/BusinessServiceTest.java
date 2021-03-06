package com.nosach.app.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nosach.app.business.BusinessService;
import com.nosach.app.business.BusinessType;
import com.nosach.app.models.requests.BusinessRequest;
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
public class BusinessServiceTest{

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;
    private BusinessRequest business;

    @MockBean
    private BusinessService businessService;

    @Before
    public void setUp() {
        business = new BusinessRequest();
        business.setBusinessType(BusinessType.HAIR_SALON);
        business.setId(1);
    }

    @Test
    public void createBusinessShouldReturnStatusCreated() throws Exception {
        mockMvc
                .perform(post("/businesses")
                        .content(mapper.writeValueAsString(this.business))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }
}
