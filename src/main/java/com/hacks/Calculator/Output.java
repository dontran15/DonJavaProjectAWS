package com.hacks.Calculator; // maven build

// import swing and awt
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Output extends JFrame {
    public Output() {
        InputInitial newInputs = new InputInitial(); // start input object from separate file

        newInputs.spawnInputs(); // start the process of collecting user input

        ShowResults(newInputs.initialNum1, newInputs.initialNum2, newInputs.initialFunct);

    }

    public void ShowResults(double num1, double num2, String funct){
        CalculatorMath calculate = new CalculatorMath(num1, num2, funct);

        JOptionPane.showMessageDialog(null, "Output: " + calculate.calculateOutput(num1, num2, funct));

    }

    public static void main(String[] args) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Output().setVisible(true);
            }
        });
        
    }
}