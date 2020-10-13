package com.nur.librarymanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String list() {
        return "index";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
