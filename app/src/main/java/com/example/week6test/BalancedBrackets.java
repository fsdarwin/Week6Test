package com.example.week6test;

public class BalancedBrackets {

    static class Stack {
        int top = -1;
        char bracket[] = new char[50];

        void push(char x) {
            if (top == 49) {
                System.out.println("Stack full");
            } else {
                bracket[++top] = x;
            }
        }

        char pop() {
            if (top == -1) {
                System.out.println("Underflow error");
                return '\0';
            } else {
                char element = bracket[top];
                top--;
                return element;
            }
        }

        boolean isEmpty() {
            return top == -1;
        }
    }

    static boolean isMatchingPair(char open, char close) {
        if (open == '(' && close == ')')
            return true;
        else if (open == '{' && close == '}')
            return true;
        else if (open == '[' && close == ']')
            return true;
        else
            return false;
    }

    static boolean areParenthesisBalanced(char exp[]) {
        Stack stack = new Stack();

        for (int i = 0; i < exp.length; i++) {
            if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[')
                stack.push(exp[i]);
            if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else if (!isMatchingPair(stack.pop(), exp[i])) {
                    return false;
                }
            }
        }
        if (stack.isEmpty())
            return true;
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        char expression[] = {'{', '(', ')', '}', '(', ')', '{', '[', ']', '}'};
        if (areParenthesisBalanced(expression))
            System.out.println("Brackets are Balanced.");
        else
            System.out.println("Brackets are NOT Balanced.");
    }
}

