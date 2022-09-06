package com.hacks.Calculator; // maven build


// import the other files


// import swing and awt
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Output extends JFrame {
    public Output() {
        InputInitial newInputs = new InputInitial(); // start input object from separate file
        newInputs.spawnInputs(); // start the process of collecting user input
    }

    public void ShowResults(double num1, double num2, String funct){
        CalculatorMath calculate = new CalculatorMath(num1, num2, funct);
        JOptionPane.showMessageDialog(null, "Output: " + calculate.calculateOutput(num1, num2, funct));

    }

    public static void main(String[] args) {
    
        // runs the creation of the graph with a queue in a different thread and posts the gui after events are processed
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // initialize new TrajectoryGraph object, setvisible to display the graph
                new Output().setVisible(true);
            }
        });
        
    }
}