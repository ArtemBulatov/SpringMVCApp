package ru.bulatov.springmvcapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request, Model model) {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        // System.out.println("Hello, " + name + " " + surname + "!");
        model.addAttribute("message", "Hello, " + name + " " + surname + "!");

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surname", required = false) String surname,
                              Model model) {

        // System.out.println("Goodbye, " + name + " " + surname + "!");
        model.addAttribute("message", "Goodbye, " + name + " " + surname + "!");

        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam int a,
                                 @RequestParam int b,
                                 @RequestParam String action,
                                 Model model) {
        double result;

        switch (action) {
            case ("multiplication"): result = a*b; break;
            case ("division"): result = a*1.0/b; break;
            case ("addition"): result = a+b; break;
            case ("subtraction"): result = a-b; break;
            default: result = 0; break;
        }

        model.addAttribute("result", "Result of " + action + " is: " + result);

        return "first/calculator";
    }


}
