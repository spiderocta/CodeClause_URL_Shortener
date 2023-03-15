package com.codeclause.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class ShortenURLController {
    @GetMapping("/")
    public String loadIndex() {
        return "index";
    }
}
