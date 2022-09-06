package com.hacks.Calculator;

import javax.swing.JOptionPane; // library to display options
import javax.swing.JTextField; // library to create a text field to render on GUI

public class InputInitial {
    // instance variables to be used
    public Double initialNum1;
    public Double initialNum2;
    public String initialFunct;

    // create the GUI element that users input into
    public void spawnInputs() {
        // while the values have not changed yet, keep going (for error handling)
        while (initialNum1 == null || initialNum2 == null || initialFunct == null) {
            // text field initialization
            JTextField inputNum1 = new JTextField();
            JTextField inputNum2 = new JTextField();
            JTextField inputFunct = new JTextField();

            // organizing the input text to display + the text field in object
            Object[] inputs = {
                "First number:", inputNum1,
                "Second number:", inputNum2,
                "Function ( + | - | * | / | sin | cos | tan | a^b | log | mod )", inputFunct
            };

            JOptionPane.showConfirmDialog(null, inputs, "Input the initial values for your object (numbers only):", JOptionPane.OK_CANCEL_OPTION); // creates the option menu with the 3 inputs

            // take the input, assign it to the public variables
            initialNum1 = parseInput(inputNum1);
            initialNum2 = parseInput(inputNum2);
            initialFunct = inputFunct.getText().toString();


        }
        
    }

    // change JTextField into Double, also error handling
    public double parseInput(JTextField inputValue) {
        String placeholder = inputValue.getText(); // get the string out of the input
        
        // error handling + edge cases
        try {
            double initialValue = Double.parseDouble(placeholder);

            return initialValue;
        } catch (Exception e) { // if cannot be cased as a double, throw error --> reinput values
            JOptionPane.showMessageDialog(null, "There was an invalid input for " + placeholder + ", please try again. " + e, "Unwanted Input", JOptionPane.WARNING_MESSAGE);
            return (Double) null;
        }
    }
}