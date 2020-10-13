package com.nur.librarymanagement.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    private UserService userService;
    private UserServiceImpl userServiceImpl;
    public UserRegistrationController(UserService userService, UserServiceImpl userServiceImpl) {
        super();
        this.userService = userService;
        this.userServiceImpl=userServiceImpl;
    }

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") User user) {
        userServiceImpl.save(user);
        return "redirect:/registration?success";

    }
}