package br.com.conference.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class GreentingController {

    @GetMapping("greeting")
    public String getGreeting(Map<String, Object> model) {
        model.put("message", "Hello Spring MVC!");
        return "greeting";
    }

    @GetMapping("thymeleaf")
    public String thymeleaf(Map<String, Object> model) {
        model.put("message", "Hello Thymeleaf !!!");
        return "thymeleaf";
    }
}
