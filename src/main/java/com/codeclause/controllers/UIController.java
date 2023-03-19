package com.codeclause.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class UIController {
    @GetMapping("/")
    public String loadIndex() {
        return "index";
    }
}
