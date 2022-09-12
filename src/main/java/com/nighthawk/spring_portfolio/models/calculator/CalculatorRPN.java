package com.nighthawk.spring_portfolio.models.calculator;

import java.util.Stack;
import java.util.ArrayList;

public class CalculatorRPN {
    ArrayList<String> tokens = new ArrayList<>();
    ArrayList<String> rpnOutput = new ArrayList<>();

    // checks for operator
    public boolean isOperator(char c) {
        switch (c) {
            case '+':
                return true;
            case '-':
                return true;
            case '*':
                return true;
            case '/':
                return true;
            case '^':
                return true;
            default:
                return false; // else of switch
        }
    }

    public boolean isParenthesis(char c) {
        switch (c) {
            case '(':
                return true;
            case ')':
                return true;
            default:
                return false;
        }
    }

    public boolean isNumber(String s) {
        return !isOperator(s.charAt(0)) && !isParenthesis(s.charAt(0));
    }

    public int getPrecedence(char c) {
        switch (c) {
            case '+':
                return 2;
            case '-':
                return 2;
            case '*':
                return 3;
            case '/':
                return 3;
            case '^':
                return 4;
            default:
                return -1;
        }
    }

    public String getAssociativity(char c) {
        switch (c) {
            case '+':
                return "left";
            case '-':
                return "left";
            case '*':
                return "left";
            case '/':
                return "left";
            case '^':
                return "right";
            default:
                return "";
        }
    }

    public double calculate(char operator, double x1, double x2) {
        switch (operator) {
            case '+':
                return x1 + x2;
            case '-':
                return x1 - x2;
            case '*':
                return x1 * x2;
            case '/':
                return x1 / x2;
            case '^':
                return Math.pow(x1, x2);
            default:
                throw new RuntimeException("Unsupported operator or function: " + operator);
        }
    }

    // parse input string as array of tokens
    public ArrayList<String> parse(String input) {
        String s = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (isNumber(String.valueOf(c))) {
                s += c;
            } else {
                s += "\n" + c + "\n";
            }
        }

        String[] splittedTokens = s.split("\n", 0);
        for (String token : splittedTokens) {
            String trimmedToken = token.trim();
            if (trimmedToken != "") {
                tokens.add(trimmedToken);
            }
        }
        return tokens;
    }

    // shunting yard algorithm to convert array to rpn
    public ArrayList<String> shuntingYardAlg() {
        Stack<String> operatorStack = new Stack<>();
        for (String token : tokens) {
            if (isNumber(token)) {
                rpnOutput.add(token);
            } else if (isOperator(token.charAt(0))) {
                while (!operatorStack.isEmpty()) {
                    char o1 = token.charAt(0);
                    char o2 = operatorStack.peek().charAt(0);
                    int o1P = getPrecedence(o1);
                    int o2P = getPrecedence(o2);
                    if ((isOperator(o2) && (o2P > o1P || (o1P == o2P && getAssociativity(o1) == "left")))) {
                        String s = operatorStack.pop();
                        rpnOutput.add(s);
                    } else {
                        break;
                    }
                }

                operatorStack.push(token);

            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    String s = operatorStack.pop();
                    rpnOutput.add(s);
                }
                operatorStack.pop();
            }

        }
        while (!operatorStack.isEmpty()) {
            String s = operatorStack.pop();
            rpnOutput.add(s);
        }
        return rpnOutput;
    }

    // evaluate rpn using stack
    public double rpnEvaluate() {
        Stack<String> resultStack = new Stack<>();
        for (String e : rpnOutput) {
            if (isNumber(e)) {
                resultStack.push(e);
            } else if (isOperator(e.charAt(0))) {
                double x2 = Double.valueOf(resultStack.pop());
                double x1 = Double.valueOf(resultStack.pop());

                double r = calculate(e.charAt(0), x1, x2);
                resultStack.push(String.valueOf(r));
            }
        }
        return Double.valueOf(resultStack.pop());
    }
}
