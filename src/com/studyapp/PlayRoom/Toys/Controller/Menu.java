package com.studyapp.PlayRoom.Toys.Controller;

import com.studyapp.PlayRoom.ToyGenerator;
import com.studyapp.PlayRoom.ToyModels.Toy;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    int toysNumber;
    double budget;
    PlayRoom playRoom;

    //Why static? You can create an instance of ToyGenerator by constructor and then call the toysArray method
    //Toy[] toy = ToyGenerator.toysArray(50);
    // [Olena] re-worked
    public Menu(int _toysNumber, double _budget) {
        this.toysNumber = _toysNumber;
        this.budget = _budget;
        ToyGenerator ttoy = new ToyGenerator();
        Toy[] tttoy = ttoy.toysArray(toysNumber);
        ToysQtyCalculator toysQtyCalculator = new ToysQtyCalculator(budget, tttoy);
        this.playRoom = new PlayRoom(toysQtyCalculator);
    }

    public void availableOptions() {
        boolean closeApp;
        do {
            System.out.println("Select an option below: ");
            System.out.println("1. Add toys to a cart");
            System.out.println("2. Sort toys on price");
            System.out.println("3. Find toys that have Small size and which price is less than " + playRoom.limPrice);
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
    private boolean userSelectsOption(String userChoice) {
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
