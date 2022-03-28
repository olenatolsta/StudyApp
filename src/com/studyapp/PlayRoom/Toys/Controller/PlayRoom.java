package com.studyapp.PlayRoom.Toys.Controller;

import com.studyapp.PlayRoom.Toys.ToyStaff.Toy;

public class PlayRoom {
    private int toysQty;
    private ToysQtyCalculator toysQ;

    //Constructor
    PlayRoom(ToysQtyCalculator toysQtyCalculator) {
        toysQ = toysQtyCalculator;
    }

    public void printArray(Toy[] arrayToPrint) {
        for (int l = 0; l < arrayToPrint.length; l++) {
            System.out.println("Toys name: " + arrayToPrint[l].getName());
            System.out.println("Cost: " + arrayToPrint[l].getCost());
            System.out.println("Size: " + arrayToPrint[l].getSize());
        }
    }

    public Toy[] addToy() {
        toysQty = toysQ.averageQuantity();
        double budget = toysQ.getBudget();
        Toy[] catalog = toysQ.getCatalog();
        Toy[] cart = new Toy[toysQty];
        int k;
        double sum = 0;
        double minPriceToyCatalog = toysQ.toyMinPrice().getCost();
        if (minPriceToyCatalog < budget) {
            for (int i = 0; i < cart.length; i++) {
                Toy randToy;
                do {
                    k = (int) (Math.random() * catalog.length);
                    randToy = catalog[k];
                } while (randToy.getCost() >= (budget - sum));
                cart[i] = randToy;
                sum = sum + randToy.getCost();
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
                if (_cart[j].getCost() > _cart[j + 1].getCost()) {
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
    public void findSpecificToys() {
        Toy[] catalog = toysQ.getCatalog();
        int k = 0;
        int specQty = (int) (Math.random() * (catalog.length / 3) + 1);
        Toy[] specToys = new Toy[specQty];
        int limPrice = (int) (Math.random() * 10 + 10);
                while (specToys[specQty - 1] == null) {
                for (int j = 0; j < catalog.length; j++) {
                    if ((catalog[j].getSize() == "Small" && catalog[j].getCost() < limPrice)&&(k<specToys.length)) {
                        specToys[k] = catalog[j];
                        k++;
                        break;
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






