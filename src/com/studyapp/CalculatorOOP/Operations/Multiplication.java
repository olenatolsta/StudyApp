package com.studyapp.CalculatorOOP.Operations;

public class Multiplication extends CalculatorAbstr {
    //constructor
    public Multiplication(double _parameterOne, double _parameterTwo) {
        super(_parameterOne, _parameterTwo);
    }

    @Override
    public void operation() {
        result = parameterOne * parameterTwo;
        System.out.println("The result of elements multiplication is: " + parameterOne + "*" + parameterTwo + "=" + result);
    }
}

