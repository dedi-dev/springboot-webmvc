package com.belajar.webmvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import javax.servlet.http.Cookie;

import org.hamcrest.Matchers;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testLogin() throws Exception {
        mockMvc.perform(
                post("/auth/login").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("username", "Dedi")
                        .param("password", "rahasia"))
                .andExpectAll(status().isOk(), content().string(Matchers.containsString("OK")),
                        cookie().value("username", Matchers.is("Dedi")));
    }

    @Test
    void testLoginFailed() throws Exception {
        mockMvc.perform(
                post("/auth/login").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("username", "edi")
                        .param("password", "rahasia"))
                .andExpectAll(status().isUnauthorized(), content().string(Matchers.containsString("NG")));
    }

    @Test
    void testGetUser() throws Exception {
        mockMvc.perform(
                get("/auth/user").cookie(new Cookie("username", "Dedi")))
                .andExpectAll(status().isOk(), content().string(Matchers.containsString("Hello Dedi")));
    }
}
