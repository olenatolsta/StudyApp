package com.studyapp.CalculatorOOP.Controller;

import java.util.Scanner;

public class CalcHandlerOOP {
    double parameter;

    public double userSelectsParameters() {
        Scanner scanDouble = new Scanner(System.in);
        do {
            System.out.println("Input parameter(s). Parameters can only be numbers.");
            while (!scanDouble.hasNextDouble()) {
                System.out.println("That's not a number. Please input a digit to proceed");
                scanDouble.next();
            }
            parameter = scanDouble.nextDouble();
            System.out.println("Element = " + parameter);
        } while (parameter == 0);
        return parameter;
    }
}
