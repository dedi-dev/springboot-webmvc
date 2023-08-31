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
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCreatePerson() throws Exception {
        String firstName = "Syaif";
        String middleName = "Azmi";
        String lastName = "Abdullah";
        String email = "azmi@gmail.com";
        String phone = "085711170919";
        String street = "Jl. Sembang";
        String city = "Karawang";
        String country = "Indonesia";
        String postalCode = "41371";

        mockMvc.perform(
                post("/person").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("firstName", firstName)
                        .param("middleName", middleName)
                        .param("lastName", lastName)
                        .param("email", email)
                        .param("phone", phone)
                        .param("address.street", street)
                        .param("address.city", city)
                        .param("address.country", country)
                        .param("address.postalCode", postalCode)
                        .param("hobbies[0]", "Rerading")
                        .param("hobbies[1]", "Coding")
                        .param("socialMedia[0].name", "Facebook")
                        .param("socialMedia[0].location", "https://facebook.com")
                        .param("socialMedia[1].name", "Instagram")
                        .param("socialMedia[1].location", "https://instagram.com"))
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString(new StringBuilder().append("Success Create Person ")
                                .append(firstName).append(" ").append(middleName).append(" ")
                                .append(lastName).append(" with email ").append(email).append(" and phone ")
                                .append(phone)
                                .append(" with address ")
                                .append(street)
                                .append(", ")
                                .append(city)
                                .append(", ").append(country).append(", ")
                                .append(postalCode)
                                .toString())));
    }
}
