package ru.bulatov.springmvcapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/my-world")
    public String sayHello() {
        return "my-world";
    }
}
