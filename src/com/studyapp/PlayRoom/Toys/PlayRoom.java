package com.studyapp.PlayRoom.Toys;

import java.io.IOException;
import java.util.Scanner;

public class PlayRoom {

    Toy[] _catalog;
    int toysQty = 10;

    //Constructor
    public PlayRoom(Toy[] catalog) {
        _catalog = catalog;
    }

    public double budget = 500;

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
                addToy(toysQty);
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

    //Find a Toy with minimal price
    public Toy toyMinPrice() {
        Toy minElement = _catalog[0];
        for (int i = 0; i < _catalog.length; i++) {
            if (_catalog[i].cost < minElement.cost) {
                minElement = _catalog[i];
            }
        }
        return minElement;
    }

   /*
    1. Find a toy, which has a minimum price
    2. Create a loop, which will compare a sum of toys prices each time a toy is added to the PlayRoom with budget.
        The loop will continue executing till the difference between sum of toys prices and the budget is bigger than
        minimum toy's price
        2.1 Create a method, that will select a toy from the catalog
            2.1.1 Создаем новьй массив такого же размера как каталог
            2.1.2 Наполняем новьій массив игрушками с минимальной ценой - фиксированное кол-во
            2.1.3 Создаем метод, которьій будет заменять игрушки с минимальной ценой на игрушки с более вьісокой ценой
            с разньіми размерами не превьішая сумму бюджета
     */

    //2.1.1 Создаем новьй массив длиной равной кол-ву игрушек
    public Toy[] addToyPreselect(int _toysQty) {
        double minPriceToy = toyMinPrice().cost;
        //наполняем корзину игрушками с минимальной ценой
        //Если стоимость игрушек с минимальной ценой, умноженная на кол-во, не превьішает бюджет, добавляем след игрушку
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
    }

    //Заменить игрушки с мин ценой на более дорогие
    public void addToy(int _toysQty) {
        Toy[] cart = new Toy[_catalog.length];
        Toy[] _preSelectedToys = addToyPreselect(_toysQty);
        double sum = 0;
        cart[0] = _preSelectedToys[0];
        for (int i = 0; i < _toysQty; i++) {
            for (int j = 0; j < _catalog.length; j++) {
                int k = (int) (Math.random() * 30);
                if (_catalog[k].cost > cart[i].cost && ((budget - sum - _catalog[k].cost) >= 0)) {
                    cart[i] = _catalog[k];
                    sum = sum + _catalog[k].cost;
                }
            }
        }
    }
}