package com.studyapp.PlayRoom.Toys;

import java.io.IOException;
import java.util.Scanner;

public class PlayRoom {
    private int toysQty;
    private ToysQtyCalculator toysQ;

    //Constructor
    PlayRoom(ToysQtyCalculator toysQtyCalculator) {
        toysQ = toysQtyCalculator;
    }

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

    public boolean userSelectsOption(String userChoice) {
        boolean closeApp = false;
        switch (userChoice) {
            case "1":
                addToy();
                break;
            case "2":
                sortToysOnPrice();
                break;
            case "3":
                findSpecificToys(10, 10);
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

    public void printArray(Toy[] arrayToPrint) {
        for (int l = 0; l < arrayToPrint.length; l++) {
            System.out.println("Toys name: " + arrayToPrint[l].name);
            System.out.println("Cost: " + arrayToPrint[l].cost);
            System.out.println("Size: " + arrayToPrint[l].size);
        }
    }

    public Toy[] addToy() {
        toysQty = toysQ.averageQuantity();
        double budget = toysQ.getBudget();
        Toy[] catalog = toysQ.getCatalog();
        Toy[] cart = new Toy[toysQty];
        int k;
        double sum = 0;
        double minPriceToyCatalog = toysQ.toyMinPrice().cost;
        if (minPriceToyCatalog < budget) {
            for (int i = 0; i < cart.length; i++) {
                Toy randToy;
                do {
                    k = (int) (Math.random() * catalog.length);
                    randToy = catalog[k];
                } while (randToy.getCost() >= (budget - sum));
                cart[i] = randToy;
                sum = sum + randToy.cost;
            }
            System.out.println("The cart is: ");

        } else System.out.println("We didn't find a toy, that fits the budget. Please increase the budget amount");
        printArray(cart);
        return cart;
    }

    public void sortToysOnPrice() {
        Toy[] _cart = addToy();
        Toy tempCartElt;
        for (int i = 0; i < _cart.length - 1; i++) {
            for (int j = 0; j < (_cart.length - i - 1); j++) {
                if (_cart[j].cost > _cart[j + 1].cost) {
                    //swap elements
                    tempCartElt = _cart[j];
                    _cart[j] = _cart[j + 1];
                    _cart[j + 1] = tempCartElt;
                }
            }
        }
        System.out.println("The cart sorted by price is: ");
        printArray(_cart);
    }

    //Find toys that have Small size and which price is less than 10
    public void findSpecificToys(int specQty, int limPrice) {
        Toy[] specToys = new Toy[10];
        Toy[] catalog = toysQ.getCatalog();
        int i = 0;
             while (specToys[specQty - 1] == null) {
                for (int j = 0; j < catalog.length; j++) {
                    if ((catalog[j].size == "Small" && catalog[j].cost < limPrice)&&(specToys[specQty - 1] == null)) {
                        specToys[i] = catalog[j];
                        i++;
                    }
                }
            }
                System.out.println("Toys that have Small size and which price is less than 10 are: ");
                printArray(specToys);
        }

    }





 /*
    1. Find a toy, which has a minimum price
    2. Create a loop, which will compare a sum of toys prices each time a toy is added to the PlayRoom with budget.
        The loop will continue executing till the difference between sum of toys prices and the budget is bigger than
        minimum toy's price
        2.1 Create a method, that will select a toy from the catalog
            2.1.1 Создаем новьй массив такого же размера как каталог
            2.1.2 Наполняем новьій массив игрушками рандомно вьібранньіми - фиксированное кол-во не превьішая сумму бюджета
     */

    /*//2.1.1 Создаем новьй массив длиной равной кол-ву игрушек
    public Toy[] addToyPreselect(int _toysQty) {

        double minPriceToy = toysQtyCalculator.toyMinPrice().cost;
        //Если стоимость игрушек, умноженная на кол-во, не превьішает бюджет, добавляем след игрушку
        Toy[] preSelectedToys = new Toy[_toysQty];
        if (minPriceToy * _toysQty < budget) {
            double sum = 0;
            for (int i = 0; i < _toysQty; i++) {
                //2.1.2 Наполняем новьій массив игрушками с минимальной ценой - фиксированное кол-во
                for (int j = 0; j < _catalog.length; j++) {
                    if (_catalog[j].cost == minPriceToy) {
                        preSelectedToys[i] = _catalog[j];
                        sum = sum + _catalog[j].cost;
                    }
                }
            }
        } else {
            System.out.println("Budget limit exceeded, minimum toy's price is " + minPriceToy);
        }
        return preSelectedToys;
    }*/






