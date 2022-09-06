package com.hacks.Calculator;

import org.jfree.data.function.Function2D;

public class CalculatorMath {
    private double num1;
    private double num2;
    private String funct;

    public CalculatorMath(double num1, double num2, String funct) {
        this.num1 = num1;
        this.num2 = num2;
        this.funct = funct;

        this.calculateOutput();
    }

    public double getNum1() {
        return this.num1;
    }

    public double getNum2() {
        return this.num2;
    }

    public String getFunct() {
        return this.funct;
    }

    

}
