package com.belajar.webmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.belajar.webmvc.service.HelloService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloService helloService;

    // @BeforeEach
    // void setUp() {
    // Mockito.when(helloService.hello(Mockito.anyString()))
    // .thenReturn("hello Guys");
    // }

    @Test
    void helloGuest() throws Exception {
        String name = "guest";
        Mockito.when(helloService.hello(name))
                .thenReturn("hello guest");

        mockMvc.perform(
                get("/hello")).andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("hello guest")));
    }

    @Test
    void helloName() throws Exception {
        String name = "Dedi";
        Mockito.when(helloService.hello(name))
                .thenReturn("hello " + name);

        mockMvc.perform(
                get("/hello").queryParam("name", name)).andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("hello " + name)));
    }
}
