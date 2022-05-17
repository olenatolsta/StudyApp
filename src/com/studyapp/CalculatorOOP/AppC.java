package com.studyapp.CalculatorOOP;

import com.studyapp.CalculatorOOP.Controller.CalcHandlerOOP;
import com.studyapp.CalculatorOOP.Controller.Menu;

public class AppC {
    public static void main(String[] args) {
        double parameterOne;
        double parameterTwo;

        CalcHandlerOOP calc = new CalcHandlerOOP();
        parameterOne = calc.userSelectsParameters();
        parameterTwo = calc.userSelectsParameters();
        Menu menu = new Menu(parameterOne, parameterTwo);
        menu.menu();
    }
}
