package com.studyapp.calculator;

import java.io.IOException;
import java.util.Scanner;

public class CalculatorHandler {

    //class variable - field
    int _arraySize;

    //Constructor, which calls an array
    CalculatorHandler(int arraySize) {
        _arraySize = arraySize;
    }

    //declare a variable, that's going to store the array with parameters
    double[] dArray;

    public boolean userSelectsOperation(char userChoice) {
        boolean closeApp = false;
        switch (userChoice) {
            case '+':
                plusOperation();
                break;
            case '-':
                minusOperation();
                break;
            case '/':
                divideOperation();
                break;
            case '*':
                multiplyOperation();
                break;
            case 'x':
                closeApp = true;
                System.out.println("Exiting the program");
                break;
            default:
                System.out.println("The input is wrong. Select an option to proceed - + - * / or x to Exit");
        }
        return closeApp;
    }

    public void menu() {
        boolean closeApp;
        do {
            System.out.println("Select an operation: '+', '-', '/', '*' or 'x' to Exit");
            Scanner input = new Scanner(System.in);
            char userChoice = input.next().charAt(0);
            closeApp = userSelectsOperation(userChoice);
            if (!closeApp) {
                System.out.println("Press Enter to proceed..");
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        while (!closeApp);
    }

    public double[] userSelectsParameters() {
        dArray = new double[_arraySize];
        int strCount = 0;
        Scanner scanDouble = new Scanner(System.in);
        do {
            System.out.println("Input parameter(s). Parameters can only be numbers.");
            for (int i = 0; i < dArray.length; i++) {
                while (!scanDouble.hasNextDouble()) {
                    System.out.println("That's not a number. Please input a digit to proceed");
                    scanDouble.next();
                }
                dArray[i] = scanDouble.nextDouble();
                System.out.println("Element " + i + "= " + dArray[i]);
                strCount = strCount++;
            }
        } while (strCount == _arraySize);
        return dArray;
    }

    public void plusOperation() {
        double sum = 0;
        double[] params = userSelectsParameters();
        for (int i = 0; i < params.length - 1; i++) {
            sum = params[i] + params[i + 1];
            System.out.println("The sum of elements is: " + params[i] + "+" + params[i + 1] + "=" + sum);
        }
    }

    public void minusOperation() {
        double diff = 0;
        double[] params = userSelectsParameters();
        for (int i = 0; i < params.length - 1; i++) {
            diff = params[i] - params[i + 1];
            System.out.println("The difference of elements is: " + params[i] + "-" + params[i + 1] + "=" + diff);
        }
    }

    public void divideOperation() {
        double divRes = 0;
        double[] params = userSelectsParameters();
        for (int i = 0; i < params.length - 1; i++) {
            while (params[i + 1] == 0) {
                System.out.println("Division by zero. Please input another parameter");
                params = userSelectsParameters();
            }
            divRes = params[i] / params[i + 1];
            System.out.println("The result of elements division is: " + params[i] + "/" + params[i + 1] + "=" + divRes);
        }
    }

    public void multiplyOperation() {
        double multRes = 0;
        double[] params = userSelectsParameters();
        for (int i = 0; i < params.length - 1; i++) {
            multRes = params[i] * params[i + 1];
            System.out.println("The result of elements multiplication is: " + params[i] + "*" + params[i + 1] + "=" + multRes);
        }
    }
}
