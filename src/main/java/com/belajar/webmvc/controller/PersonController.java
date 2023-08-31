package com.belajar.webmvc.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.belajar.webmvc.model.CreatePersonRequest;

@Controller
public class PersonController {

    @PostMapping(path = "/person", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public String createPerson(@ModelAttribute CreatePersonRequest request) {
        System.out.println("Request : " + request);
        return new StringBuilder().append("Success Create Person ")
                .append(request.getFirstName()).append(" ").append(request.getMiddleName()).append(" ")
                .append(request.getLastName()).append(" with email ").append(request.getEmail()).append(" and phone ")
                .append(request.getPhone())
                .append(" with address ")
                .append(request.getAddress().getStreet())
                .append(", ")
                .append(request.getAddress().getCity())
                .append(", ").append(request.getAddress().getCountry()).append(", ")
                .append(request.getAddress().getPostalCode())
                .toString();
    }
}
