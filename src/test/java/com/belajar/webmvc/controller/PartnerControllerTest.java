package com.belajar.webmvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;

@SpringBootTest
@AutoConfigureMockMvc
public class PartnerControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetPartner() throws Exception{
        mockMvc.perform(
            get("/partner/current").header("X-API-KEY", "API-KEY")
        ).andExpectAll(
            status().isOk(),
            content().string(Matchers.containsString("API-KEY:Sample Partner"))
        );
    }
}
