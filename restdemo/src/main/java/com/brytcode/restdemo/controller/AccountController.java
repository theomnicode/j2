package com.brytcode.restdemo.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @GetMapping("/account/{aid}")
    public String getDetails(@PathVariable("aid") String aid){
        return "Hello "+aid;
    }
}
