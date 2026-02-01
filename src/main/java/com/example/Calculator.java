package main.java.com.example;

public class Calculator {

    public int calculate(int a, int b, String op) {
        // Fix: Merged identical cases using comma-separated labels to resolve the SonarCloud smell
        switch (op) {
            case "add", "add-again": 
                return a + b;
            case "sub", "sub-again":
                return a - b;
            case "mul":
                return a * b;
            case "div":
                return (b == 0) ? 0 : a / b;
            case "mod":
                return a % b;
            case "pow":
                return (int) Math.pow(a, b);
            default:
                return 0;
        }
    }

    public int add(int a, int b) {
        return a + b;
    }
}