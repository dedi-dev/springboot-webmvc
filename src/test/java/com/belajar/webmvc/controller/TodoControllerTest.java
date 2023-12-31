package com.belajar.webmvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testPostTodo() throws Exception{
        mockMvc.perform(
            post("/todos").queryParam("todo", "Coding")
        ).andExpect(result -> {
            System.out.println(result.getResponse().getContentAsString());
        });

        mockMvc.perform(
            get("/todos")
        ).andExpect(result -> {
            System.out.println(result.getResponse().getContentAsString());
        });
    }
}
