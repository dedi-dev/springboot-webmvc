package com.belajar.webmvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class HeaderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHeader() throws Exception {
        mockMvc.perform(
                get("/header/token").header("X-TOKEN", "TOKEN")).andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("OK")));
    }
}
