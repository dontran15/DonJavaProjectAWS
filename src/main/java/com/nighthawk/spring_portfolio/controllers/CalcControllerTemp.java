package com.nighthawk.spring_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nighthawk.spring_portfolio.models.calculator.*;

@Controller // HTTP requests are handled as a controller, using the @Controller annotation
public class CalcControllerTemp {

    // CONTROLLER handles GET request for /calculator, maps it to calculator()
    // method
    @GetMapping("/calculatorTemp")
    public String calculator(@RequestParam(name = "input", required = false) String input, Model model) {
        // If no output parameter has been inputted
        String output;
        if (input != null) {
            output = Calculator.calculate(input);
        } else {
            output = "";
        }

        // model to map output into html
        model.addAttribute("output", output);

        // load HTML VIEW (calculator.html)
        return "calculatorTemp";

    }

}
