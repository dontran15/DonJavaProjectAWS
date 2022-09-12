package com.nighthawk.spring_portfolio.models.calculator;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        String input = "-12        +4 *2/(1  -5) ^2  ^3";
        CalculatorRPN calcRPN = new CalculatorRPN();
        ArrayList<String> tokens = calcRPN.parse(input);
        for (String token : tokens) {
            System.out.println(token);
        }

        System.out.println("Token Length: " + tokens.size());
        System.out.println(calcRPN.shuntingYardAlg());
        System.out.println(calcRPN.rpnEvaluate());
    }
}
