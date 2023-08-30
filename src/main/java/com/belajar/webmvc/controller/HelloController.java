package com.belajar.webmvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.belajar.webmvc.service.HelloService;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping(value = "/hello")
    public void postMethodName(@RequestParam(name = "name", required = false) String name, HttpServletResponse response)
            throws IOException {
        String responseBody = helloService.hello(name);
        response.getWriter().println(responseBody);
    }

}
