package com.tai.code.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testAPI {
    @GetMapping("/test")
    public String newAPI(){
        return "Hello World";
    }
}
