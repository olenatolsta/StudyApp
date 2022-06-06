package com.studyapp.StudentsCourse.Controller;

import com.studyapp.CalculatorOOP.Operations.*;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
        //declare a variable, that's going to store the created object
        CalculatorAbstr objectCreation;

        private boolean userSelectsOperation(char userChoice) {
            boolean closeApp = false;
            switch (userChoice) {
                case '0':
                    //objectCreation = new Sum(parameterOne, parameterTwo);
                    System.out.println("Short report: ");
                    break;
                case '1':
                    System.out.println("Detailed report: ");
                    //objectCreation = new Subtraction(parameterOne, parameterTwo);
                    break;
                case 'x':
                    closeApp = true;
                    System.out.println("Exiting the program");
                    break;
                default:
                    System.out.println("The input is wrong. Select an option to proceed 0, 1 or x to Exit");
            }
            return closeApp;
        }

      /*  private void operationCall() {
            objectCreation.operation();
        }*/

        public void menu() {
            boolean closeApp;
            do {
                System.out.println("Select the type of report: '0' - for short report, '1' - for detailed report or 'x' to Exit");
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
