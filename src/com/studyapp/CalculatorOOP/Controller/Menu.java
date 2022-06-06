package com.studyapp.CalculatorOOP.Controller;

import com.studyapp.CalculatorOOP.Operations.*;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private double parameterOne;
    private double parameterTwo;
    //declare a variable, that's going to store the created object
    CalculatorAbstr objectCreation;

    //constructor
    public Menu(double _parameterOne, double _parameterTwo) {
        this.parameterOne = _parameterOne;
        this.parameterTwo = _parameterTwo;
    }

    private boolean userSelectsOperation(char userChoice) {
        boolean closeApp = false;
        switch (userChoice) {
            case '+':
                objectCreation = new Sum(parameterOne, parameterTwo);
                break;
            case '-':
                objectCreation = new Subtraction(parameterOne, parameterTwo);
                break;
            case '/':
                objectCreation = new Division(parameterOne, parameterTwo);
                break;
            case '*':
                objectCreation = new Multiplication(parameterOne, parameterTwo);
                break;
            case 'x':
                closeApp = true;
                System.out.println("Exiting the program");
                break;
            default:
                System.out.println("The input is wrong. Select an option to proceed - + - * / or x to Exit");
        }
        operationCall();
        return closeApp;
    }

    private void operationCall() {
        objectCreation.operation();
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
}
