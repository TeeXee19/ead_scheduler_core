package com.interra.ead_scheduler_core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@RestController
public class EadSchedulerCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(EadSchedulerCoreApplication.class, args);
	}
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
