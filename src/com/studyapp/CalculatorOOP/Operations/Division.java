package com.studyapp.CalculatorOOP.Operations;

import com.studyapp.CalculatorOOP.Controller.CalcHandlerOOP;

public class Division extends CalculatorAbstr {
    //constructor
    public Division(double _parameterOne, double _parameterTwo) {
        super(_parameterOne, _parameterTwo);
    }

    CalcHandlerOOP calculate = new CalcHandlerOOP();

    @Override
    public void operation() {
        while (parameterTwo == 0) {
            System.out.println("Division by zero. Please input another parameter");
            parameterTwo = calculate.userSelectsParameters();
        }
        result = parameterOne / parameterTwo;
        System.out.println("The result of elements division is: " + parameterOne + "/" + parameterTwo + "=" + result);
    }
}
