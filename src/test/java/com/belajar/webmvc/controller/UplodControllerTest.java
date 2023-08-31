package com.belajar.webmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.IOException;

@SpringBootTest
@AutoConfigureMockMvc
public class UplodControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testUpload() throws IOException, Exception {
        String name = "Dedi";
        String path = "upload\\profile.jpg";
        mockMvc.perform(
                multipart("/upload/profile")
                        .file(new MockMultipartFile("profile", "profile.jpg", "image/jpg",
                                getClass().getResourceAsStream("/images/profile.jpg")))
                        .contentType(MediaType.MULTIPART_FORM_DATA).param("name", name))
                .andExpectAll(
                        status().isOk(),
                        content().string(
                                Matchers.containsString("Success save profile name : " + name + ", to : " + path)));
    }
}
