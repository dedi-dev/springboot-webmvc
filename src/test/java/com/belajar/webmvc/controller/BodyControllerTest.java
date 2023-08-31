package com.belajar.webmvc.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.belajar.webmvc.model.HelloRequest;
import com.belajar.webmvc.model.HelloResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class BodyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testBody() throws JsonProcessingException, Exception {
        HelloRequest request = new HelloRequest("Dedi");
        mockMvc.perform(
                post("/body/hello").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpectAll(
                        status().isOk())
                .andExpect(result -> {
                    String responseBody = result.getResponse().getContentAsString();
                    HelloResponse response = objectMapper.readValue(responseBody, HelloResponse.class);
                    Assertions.assertEquals("Hello Dedi", response.getHello());
                });
    }
}
