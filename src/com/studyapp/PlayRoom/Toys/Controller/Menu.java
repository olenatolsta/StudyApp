package com.studyapp.PlayRoom.Toys.Controller;

import com.studyapp.PlayRoom.Toys.ToyStaff.Toy;
import com.studyapp.PlayRoom.Toys.ToyStaff.ToyGenerator;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    //Why static? You can create an instance of ToyGenerator by constructor and then call the toysArray method
    Toy[] toy = ToyGenerator.toysArray(50);
    ToysQtyCalculator toysQtyCalculator = new ToysQtyCalculator(200, toy);
    PlayRoom playRoom = new PlayRoom(toysQtyCalculator);

    public void availableOptions() {
        boolean closeApp;
        do {
            System.out.println("Select an option below: ");
            System.out.println("1. Add toys to a cart");
            System.out.println("2. Sort toys on price");
            System.out.println("3. Find toys that have Small size and which price is less than 10");
            System.out.println("0. To Exit");
            Scanner input = new Scanner(System.in);
            String userChoice = input.nextLine();
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

    //why public?
    public boolean userSelectsOption(String userChoice) {
        boolean closeApp = false;
        switch (userChoice) {
            case "1":
                playRoom.addToy();
                break;
            case "2":
                playRoom.sortToysOnPrice();
                break;
            case "3":
                playRoom.findSpecificToys();
                break;
            case "0":
                closeApp = true;
                System.out.println("Exiting the program");
                break;
            default:
                System.out.println("The input is wrong. Select an option to proceed 1, 2, 3 or x to Exit");
        }
        return closeApp;
    }
}
