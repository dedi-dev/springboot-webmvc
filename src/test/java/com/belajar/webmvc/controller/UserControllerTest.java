package com.belajar.webmvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.belajar.webmvc.model.User;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetUser() throws Exception {
        String username = "Dedi";

        mockMvc.perform(
            get("/user/current").sessionAttr("user", new User(username))
        ).andExpectAll(
            status().isOk(),
            content().string(Matchers.containsString("Hello " + username))
        );
    }

    @Test
    void testGetUserInvalid() throws Exception {
        mockMvc.perform(
            get("/user/current")
        ).andExpectAll(
            status().is3xxRedirection()
        );
    }
}
