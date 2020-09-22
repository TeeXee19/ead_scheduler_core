package com.interra.ead_scheduler_core.controller;


import com.interra.ead_scheduler_core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;


}