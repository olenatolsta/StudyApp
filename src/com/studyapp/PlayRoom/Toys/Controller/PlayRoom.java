package com.studyapp.PlayRoom.Toys.Controller;

import com.studyapp.PlayRoom.ToyModels.Toy;

public class PlayRoom {
    private final ToysQtyCalculator toysQ; //should be final - [Olena] Changed to final
    int limPrice = (int) (Math.random() * 10 + 10);

    //Constructor
    PlayRoom(ToysQtyCalculator toysQtyCalculator) {
        toysQ = toysQtyCalculator;
    }

    public void printArray(Toy[] arrayToPrint)
    {
        //other option for 'for' loop  - - [Olena] Changed to foreach
        for (Toy k : arrayToPrint) {
            System.out.println("Toys name: " + k.getName());
            System.out.println("Cost: " + k.getCost());
            System.out.println("Size: " + k.getSize());
        }
    }

    //What should an access modifier be here? [Olena] Changed to default from public
    Toy[] addToy() {
        int toysQty;
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

    //What should an access modifier be here? [Olena] Changed to default from public
    void sortToysOnPrice() {
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
    //What should an access modifier be here?  [Olena] Changed to default from public
    void findSpecificToys() {
        Toy[] catalog = toysQ.getCatalog();
        int k = 0;
        int specQty = (int) (Math.random() * (catalog.length / 3) + 1);
        Toy[] specToys = new Toy[specQty];
        while (specToys[specQty - 1] == null) {
            //other option for 'for' loop - [Olena changed]
            for (Toy j : catalog) {
                //equal method for string - [Olena] changed
                if ((j.getSize().equals("Small") && j.getCost() < limPrice) && (k < specToys.length)) {
                    specToys[k] = j;
                    k++;
                    break;
                }
            }
        }
        System.out.println("Toys that have Small size and which price is less than " + limPrice + " are: ");
        printArray(specToys);
    }
}