package com.belajar.webmvc.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            return "hello Guest";
        } else {
            return "hello " + name;
        }
    }
    
}
