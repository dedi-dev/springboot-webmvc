package com.belajar.webmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.belajar.webmvc.model.CreateAddressRequest;
import com.belajar.webmvc.model.CreatePersonRequest;
import com.belajar.webmvc.model.CreateSocialMediaRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonAPiControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreatePerson() throws Exception {
        List<CreateSocialMediaRequest> socialMedia = new ArrayList<>();
        socialMedia.add(new CreateSocialMediaRequest("Facebook", "https://facebook.com"));

        CreateAddressRequest address = new CreateAddressRequest();
        address.setCity("Karawang");
        address.setCountry("Indonesia");
        address.setPostalCode("41371");
        address.setStreet("Jl. Sembang");

        List<String> hobbies = List.of("Coding", "Belajar");

        CreatePersonRequest request = new CreatePersonRequest();
        request.setAddress(address);
        request.setHobbies(hobbies);
        request.setSocialMedia(socialMedia);
        request.setEmail("null@email.com");
        request.setFirstName("Syaif");
        request.setMiddleName("Azmi");
        request.setLastName("Abdullah");
        request.setPhone("085711170818");

        String jsonRequest = objectMapper.writeValueAsString(request);

        System.out.println("jsonRequest : " + jsonRequest);

        mockMvc.perform(
            post("/api/person").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(jsonRequest)
        ).andExpectAll(
            status().isOk(),
            content().json(jsonRequest)
        );
    }

    @Test
    void testCreatePersonNotValid() throws Exception {
        List<CreateSocialMediaRequest> socialMedia = new ArrayList<>();
        socialMedia.add(new CreateSocialMediaRequest("Facebook", "https://facebook.com"));

        CreateAddressRequest address = new CreateAddressRequest();
        address.setCity("Karawang");
        address.setCountry("Indonesia");
        address.setPostalCode("41371");
        address.setStreet("Jl. Sembang");

        List<String> hobbies = List.of("Coding", "Belajar");

        CreatePersonRequest request = new CreatePersonRequest();
        request.setAddress(address);
        request.setHobbies(hobbies);
        request.setSocialMedia(socialMedia);
        request.setEmail("null@email.com");
        // request.setFirstName("Syaif");
        request.setMiddleName("Azmi");
        request.setLastName("Abdullah");
        request.setPhone("085711170818");

        String jsonRequest = objectMapper.writeValueAsString(request);

        System.out.println("jsonRequest : " + jsonRequest);

        mockMvc.perform(
            post("/api/person").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(jsonRequest)
        ).andExpectAll(
            status().isBadRequest(),
            content().string(Matchers.containsString("Validation Error"))
        );
    }
}
