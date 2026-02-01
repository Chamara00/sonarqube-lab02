package main.java.com.example;

public class Calculator {

    public int calculate(int a, int b, String op) {
        // Fix: Use switch to reduce cyclomatic complexity and magic string issues
        switch (op) {
            case "add":
            case "add-again": // Handled under one case to remove duplicated logic
                return a + b;
            case "sub":
            case "sub-again":
                return a - b;
            case "mul":
                return a * b;
            case "div":
                return (b == 0) ? 0 : a / b;
            case "mod":
                return a % b;
            case "pow":
                return (int) Math.pow(a, b); // Use built-in method to simplify
            default:
                return 0;
        }
    }

    // Fix: Removed duplicate addNumbers, sumValues, and addAgain methods.
    // Use this single method for all addition needs.
    public int add(int a, int b) {
        return a + b;
    }
}