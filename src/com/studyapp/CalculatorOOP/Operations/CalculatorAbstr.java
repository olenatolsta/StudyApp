package com.studyapp.CalculatorOOP.Operations;

//Abstract calculator characteristics
public abstract class CalculatorAbstr {
        double parameterOne;
        double parameterTwo;
        double result;

    //Constructor
    CalculatorAbstr(double _parameterOne, double _parameterTwo) {
        this.parameterOne = _parameterOne;
        this.parameterTwo = _parameterTwo;
    }

    public abstract void operation();
}
