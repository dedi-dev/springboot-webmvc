package com.belajar.webmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ResponseController {
    
    @DeleteMapping(path = "products/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteProduct(@PathVariable("id") Integer id) {
        return "";
    }
}
