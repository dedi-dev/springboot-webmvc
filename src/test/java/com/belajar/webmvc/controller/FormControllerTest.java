package com.belajar.webmvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
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
    void testCreatePerson() throws Exception {
        String name = "Dedi";
        String birthDate = "1995-02-04";
        String address = "Karawang";
        mockMvc.perform(
                post("/form/person").contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE).param("name", name)
                        .param("birthDate", birthDate).param("address", address))
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString(
                                "Success create person with name : " + name + ", birth date : " + birthDate
                                        + ", address : " + address)));
    }

    @Test
    void testFormHello() throws Exception {
        mockMvc.perform(
                post("/form/hello")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .queryParam("name", "Andi"))
                .andExpectAll(
                        status().isOk(),
                        header().string(HttpHeaders.CONTENT_TYPE, Matchers.containsString(MediaType.TEXT_HTML_VALUE)),
                        content().string(Matchers.containsString("Hello Andi")));
    }
}
