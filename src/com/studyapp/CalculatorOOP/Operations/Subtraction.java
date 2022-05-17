package com.studyapp.CalculatorOOP.Operations;

public class Subtraction extends CalculatorAbstr {
    //constructor
    public Subtraction(double _parameterOne, double _parameterTwo) {
        super(_parameterOne, _parameterTwo);
    }

    @Override
    public void operation() {
        double result = 0;
        result = parameterOne - parameterTwo;
        System.out.println("The difference of elements is: " + parameterOne + "-" + parameterOne + "=" + result);
    }
}
