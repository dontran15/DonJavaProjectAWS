package com.nighthawk.spring_portfolio.models.calculator;

import java.util.ArrayList;

public class Calculator {
    // ArrayList of all term values and operators
    private ArrayList<Double> termValues = new ArrayList<>();
    private ArrayList<String> operators = new ArrayList<>();

    // Getters and Setters for ArrayLists
    public ArrayList<Double> getTermValues() {
        return this.termValues;
    }

    public void setTermValues(ArrayList<Double> termValues) {
        this.termValues = termValues;
    }

    public ArrayList<String> getOperators() {
        return this.operators;
    }

    public void setOperators(ArrayList<String> operators) {
        this.operators = operators;
    }

    // Parser (For now it parses the string user input into ArrayLists)
    public static String calculate(String inputString) {
        String input = inputString.replaceAll(" ", "");
        Calculator calculator = new Calculator(); // instantiate calculator
        String[] parsedInput = input.split("[+\\-\\*/]"); // parse term values
        if (parsedInput.length == 1) { // checks if split doesnt happen (result if a nonvalid input is inputted)
            return input;
        }
        double output = 0; // output term

        try {
            for (String t : parsedInput) { // adds to term values to termValues ArrayList
                calculator.termValues.add(Double.valueOf(t));
            }

            for (int i = 0; i < input.length() - 1;) {
                for (int t = 0; t < parsedInput.length - 1; t++) {
                    int tLength = parsedInput[t].length();
                    i += tLength;
                    if (i >= input.length()) {
                        break;
                    }
                    char operator = input.charAt(i);
                    if (t == 0) {
                        switch (operator) {
                            case '+':
                                output += Double.valueOf(parsedInput[t]) + Double.valueOf(parsedInput[t + 1]);
                                i++;
                                break;
                            case '-':
                                output += Double.valueOf(parsedInput[t]) - Double.valueOf(parsedInput[t + 1]);
                                i++;
                                break;
                            case '*':
                                output += Double.valueOf(parsedInput[t]) * Double.valueOf(parsedInput[t + 1]);
                                i++;
                                break;
                            case '/':
                                output += Double.valueOf(parsedInput[t]) / Double.valueOf(parsedInput[t + 1]);
                                i++;
                                break;
                        }
                    } else {
                        switch (operator) {
                            case '+':
                                output += Double.valueOf(parsedInput[t + 1]);
                                i++;
                                break;
                            case '-':
                                output -= Double.valueOf(parsedInput[t + 1]);
                                i++;
                                break;
                            case '*':
                                output *= Double.valueOf(parsedInput[t + 1]);
                                i++;
                                break;
                            case '/':
                                output /= Double.valueOf(parsedInput[t + 1]);
                                i++;
                                break;
                        }
                    }
                }
            }

            return String.valueOf(output);
        } catch (Exception e) {
            return "Invalid Input";
        }
    }

    // Uses ArrayLists to calculate and parse: (TODO: Implement tree data structure
    // to create calculator w/ order of operations)
    // public double calculate(ArrayList<Double> termValues, ArrayList<String>
    // operators) {
    // double output = 0;

    // return output;
    // }

}
