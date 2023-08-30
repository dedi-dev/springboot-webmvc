package com.belajar.webmvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;

@SpringBootTest
@AutoConfigureMockMvc
public class FormControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    void testFormHello() throws Exception {
        mockMvc.perform(
            post("/form/hello")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .queryParam("name", "Andi")
        ).andExpectAll(
            status().isOk(),
            content().string(Matchers.containsString("hello Andi"))
        );
    }
}
