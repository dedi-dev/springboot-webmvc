package com.belajar.webmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.belajar.webmvc.model.HelloRequest;
import com.belajar.webmvc.model.HelloResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class BodyController {

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping(path = "/body/hello", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String body(@RequestBody String requestBody) throws JsonMappingException, JsonProcessingException {
        HelloRequest request = objectMapper.readValue(requestBody, HelloRequest.class);
        HelloResponse response = new HelloResponse();
        response.setHello("Hello " + request.getName());
        return objectMapper.writeValueAsString(response);
    }
}
