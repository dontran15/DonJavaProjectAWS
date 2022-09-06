package com.nighthawk.spring_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nighthawk.spring_portfolio.models.calculator.*;

@Controller // HTTP requests are handled as a controller, using the @Controller annotation
public class CalcController {

    // CONTROLLER handles GET request for /calculator, maps it to calculator()
    // method
    @GetMapping("/calculator")
    public String calculator(
            @RequestParam(name = "input", required = false) String input, Model model) {
        // TODO: call calculator to do the actual work
        String output;
        if (input != null) {
            output = Calculator.calculate(input);
        } else {
            output = "";
        }

        model.addAttribute("output", output);

        // load HTML VIEW (calculator.html)
        return "calculator";

    }

}
