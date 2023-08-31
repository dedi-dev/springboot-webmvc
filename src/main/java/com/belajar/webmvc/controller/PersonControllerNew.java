package com.belajar.webmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.belajar.webmvc.model.CreatePersonRequest;

@Controller
public class PersonControllerNew {

    @PostMapping(path = "/person-new", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public ResponseEntity<String> createPerson(@ModelAttribute @Valid CreatePersonRequest request, BindingResult bindingResult) {
        System.out.println("Request : " + request);

        // List<ObjectError> allErrors = bindingResult.getAllErrors();
        // if (!allErrors.isEmpty()) {
        //     allErrors.forEach(error -> {
        //         System.out.println(error.getDefaultMessage());
        //     });

        //     return ResponseEntity.badRequest().body("You send invalid data");
        // }

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if (!fieldErrors.isEmpty()) {
            fieldErrors.forEach(error -> {
                System.out.println(error.getField() + " " + error.getDefaultMessage());
            });

            return ResponseEntity.badRequest().body("You send invalid data");
        }

        String response = new StringBuilder().append("Success Create Person ")
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

        return ResponseEntity.ok(response);
    }
}
