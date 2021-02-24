package com.soft.demosoftunispring.controllers;

import com.soft.demosoftunispring.entities.User;
import com.soft.demosoftunispring.servives.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class AppController implements CommandLineRunner {

    private final UserService userService;

    public AppController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
    userService.persistUser();
    }
}
