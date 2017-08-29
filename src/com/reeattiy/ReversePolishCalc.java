package com.reeattiy;


public class ReversePolishCalc {

    // You'll need a variable here to keep track of the top of the stack
    private int top;

    // The array of the input string split up
    private String[] tokens;

    // The stack
    private String[] stack;

    public double calculate(String input) {
        top = -1;
        // 1. Use the String split method to split the string into tokens at the commas
        tokens = input.split(",");

        // 2. Allocate a stack as big as the number of tokens
        stack = new String[tokens.length];

        // 3. write the algorithm
        for (int i = 0; i < tokens.length; ++i) {
            // calls to push() and pop() and do the math here
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                double num1 = pop();
                double num2 = pop();
                if (tokens[i].equals("+")) {
                    push(num1 + num2);
                } else if (tokens[i].equals("-")) {
                    push(num1 - num2);
                } else if (tokens[i].equals("*")) {
                    push(num1 * num2);
                } else if (tokens[i].equals("/")) {
                    push(num1 / num2);
                }

            } else {
                push(tokens[i]);
            }


        }

        // 4. return the result
        return pop();
    }

    private void push(String number) {
        // push on the stack
        top++;
        stack[top] = number;
    }

    private void push(double d) {
        // change the double to a string and then push it on the stack
        String temp = Double.toString(d);
        push(temp);
    }

    private double pop() {
        // remove the string from the top of the stack and convert it to a double and return it
        String temp = stack[top];
        top--;
        return Double.parseDouble(temp);


    }

}


