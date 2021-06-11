package com.senior.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    @GetMapping("/test")
    public String test(@RequestParam(name = "name", defaultValue = "error") String name) {
        return String.format("Testando, %s", name);
    }

}
