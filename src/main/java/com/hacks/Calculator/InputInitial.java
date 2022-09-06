// package com.hacks.Calculator;

// import javax.swing.JOptionPane; // library to display options
// import javax.swing.JTextField; // library to create a text field to render on GUI

// public class InputInitial {
//     // instance variables to be used
//     public static Double num1;
//     public static Double num2;
//     public static String funct;

//     // create the GUI element that users input into
//     public void spawnInputs() {
//         // while the values have not changed yet, keep going (for error handling)
//         while (num1 == null || num2 == null || funct == null) {
//             // text field initialization
//             JTextField num1 = new JTextField();
//             JTextField num2 = new JTextField();
//             JTextField funct = new JTextField();

//             // organizing the input text to display + the text field in object
//             Object[] inputs = {
//                 "First number:", num1,
//                 "Second number:", num2,
//                 "Function:", funct
//             };

//             JOptionPane.showConfirmDialog(null, inputs, "Input the initial values for your object (numbers only):", JOptionPane.OK_CANCEL_OPTION); // creates the option menu with the 3 inputs

//             // take the input, assign it to the public variables
//             num1 = parseInput(num1);
//             num2 = parseInput(num2);
//             funct = parseInput(funct);
//         }
        
//     }

//     // change JTextField into Double, also error handling
//     public double parseInput(JTextField inputValue) {
//         String placeholder = inputValue.getText(); // get the string out of the input
        
//         // error handling + edge cases
//         try {
//             double initialValue = Double.parseDouble(placeholder);

//             // if negative, cannot be valid so throw error --> reinput values bc still null
//             if (initialValue < 0.0) {
//                 JOptionPane.showMessageDialog(null, "Inputs must be greater than 0", "Invalid Input", JOptionPane.WARNING_MESSAGE);
//                 return null;
//             } else { // if everything ok, return the value
//                 return initialValue;
//             }
            
//         } catch (Exception e) { // if cannot be cased as a double, throw error --> reinput values
//             JOptionPane.showMessageDialog(null, "There was an invalid input for " + placeholder + ", please try again. " + e, "Unwanted Input", JOptionPane.WARNING_MESSAGE);
//             return null;
//         }
//     }
// }