package com.nur.librarymanagement.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @RequestMapping("/user")
    public String loginUser(){
        return "Login Succesfull";
    }
    @RequestMapping("/admin")
    public String loginAdmin(){
        return "Admin Login succesfull";
    }
}
