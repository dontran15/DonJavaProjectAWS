package com.hacks.Calculator;

import java.lang.Math;

public class CalculatorMath {
    private double num1;
    private double num2;
    private String funct;

    public CalculatorMath(double num1, double num2, String funct) {
        this.num1 = num1;
        this.num2 = num2;
        this.funct = funct;

        this.calculateOutput(num1, num2, funct);
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

    public void setNum1(double num1) {
        this.num1 = num1;
    }


    public double calculateOutput(double num1, double num2, String funct){
        double Output = 0;

        if (funct == "+"){
            Output = num1 + num2;
        }
        else if (funct == "-"){
            Output = num1 - num2;
        }
        else if (funct == "*"){
            Output = num1 * num2;
        }
        else if (funct == "/"){
            Output = num1 / num2;
        }
        else if (funct == "sin"){
            Output = Math.sin(num1);
        }
        else if (funct == "cos"){
            Output = Math.cos(num1);
        }
        else if (funct == "tan"){
            Output = Math.tan(num1);
        }
        else if (funct == "a^b"){
            Output = Math.pow(num1, num2);
        }
        else if (funct == "mod"){
            Output = num1 % num2;
        }
        else if (funct == "log"){
            Output = Math.log(num1)/Math.log(num2);
        }
        

        return(Output);
    }

}
