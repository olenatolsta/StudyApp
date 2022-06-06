package com.studyapp.CalculatorOOP.Operations;

public class Sum extends CalculatorAbstr {
    //constructor
    public Sum(double _parameterOne, double _parameterTwo) {
        super(_parameterOne, _parameterTwo);
    }

    @Override
    public void operation() {
        double result = 0;
        result = parameterOne + parameterTwo;
        System.out.println("The sum of elements is: " + parameterOne + "+" + parameterTwo + "=" + result);
    }
}

