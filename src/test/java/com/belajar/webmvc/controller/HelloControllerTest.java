package com.belajar.webmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

// import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
// import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;



@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloGuest() throws Exception {
        mockMvc.perform(
            get("/hello")
        ).andExpectAll(
            status().isOk(),
            content().string(Matchers.containsString("hello Guest"))
        );
    }

    @Test
    void helloName() throws Exception {
        String name = "Dedi";
        mockMvc.perform(
            get("/hello").queryParam("name", name)
        ).andExpectAll(
            status().isOk(),
            content().string(Matchers.containsString("hello " + name))
        );
    }

    @Test
    void testMethodNotAllowed() throws Exception {
        String name = "Dedi";
        mockMvc.perform(
            post("/hello").queryParam("name", name)
        ).andExpectAll(
            status().isMethodNotAllowed()
        );
    }
}
