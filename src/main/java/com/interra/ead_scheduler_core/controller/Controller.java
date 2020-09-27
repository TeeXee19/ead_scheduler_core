
package com.interra.ead_scheduler_core.controller;

import com.interra.ead_scheduler_core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/api")
public class Controller {
    
    @Autowired
    public UserService userService;
    
}
