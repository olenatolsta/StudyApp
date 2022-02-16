package com.studyapp.PlayRoom.Toys;

import java.io.IOException;
import java.util.Scanner;

public class FIllPlayRoom {

    //Constructor
    public FIllPlayRoom() {
    }

    public void availableOptions() {
        boolean closeApp;
        do {
            System.out.println("Select an option below: ");
            System.out.println("1. Add a toy");
            System.out.println("2. Sort toys on price");
            System.out.println("3. Sort toys on name");
            System.out.println("4. Find 3 toys that are most expensive and smallest");
            System.out.println("0. To Exit");
            Scanner input = new Scanner(System.in);
            char userChoice = input.next().charAt(0);
            closeApp = userSelectsOption(userChoice);
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

    public boolean userSelectsOption(char userChoice) {
        boolean closeApp = false;
        switch (userChoice) {
            case 1:
                addToy();
                break;
          /*  case 2:
                sortToysOnPrice();
                break;
            case 3:
                sortToysOnName();
                break;
            case 4:
                findSpecificToys();
                break;
            case '0':
                closeApp = true;
                System.out.println("Exiting the program");
                break;*/
            default:
                System.out.println("The input is wrong. Select an option to proceed - + - * / or x to Exit");
        }
        return closeApp;
    }

    public void addToy() {

    }


}


