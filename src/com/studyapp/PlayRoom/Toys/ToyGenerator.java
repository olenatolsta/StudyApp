package com.studyapp.PlayRoom.Toys;

public class ToyGenerator {

    //1. Create price list
    private final static String SOURCE_PATH = "price.txt";

    //class variable - field
    int _toysNumber;

    //Constructor, which calls an array
    ToyGenerator(int toysNumber) {
        _toysNumber = toysNumber;
    }

    //declare a variable, that's going to store the array
    static Toy[] priceList;

    //   1.1.1 On each step of the loop randomly choose a type of toy that should be created
    private String randomToyType() {
        int n = 0;
        String toyType[] = {"BeachToys", "BuildingBricks", "DevToys", "StuffedToys", "Vehicles"};
        for (int i = 0; i < toyType.length; i++) {
            n = (int) (Math.random() * 5);
        }
        return toyType[n];
    }

    //Initialize the array with toys prices
    // 1.1.3 Randomly generate a price
    public static double getPrice() {
        double n = (int) (Math.random() * 15.23 + 5);
        return n;
    }

    //1.1.4 Randomly generate a size
    private String getSize() {
        int n = 0;
        String toySize[] = {"Small", "Middle", "Big"};
        for (int i = 0; i < toySize.length; i++) {
            n = (int) (Math.random() * 3);
        }
        return toySize[n];
    }

    //1.1.2 Create an object of selected type (switch-case)
    public Toy generateToy() {
        Toy toyObject;
        switch (randomToyType()) {
            case "BeachToys":
                toyObject = new BeachToys(null, getSize(), getPrice());
                break;
            case "StuffedToys":
                toyObject = new StuffedToys(null, getSize(), getPrice());
                break;
            case "BuildingBricks":
                toyObject = new StuffedToys(null, getSize(), getPrice());
                break;
            case "DevToys":
                toyObject = new StuffedToys(null, getSize(), getPrice());
                break;
            case "Vehicles":
                toyObject = new StuffedToys(null, getSize(), getPrice());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + randomToyType());
        }
        return toyObject;
    }

    //   1.1 Create a loop from 0 to _toysNumber
    public Toy[] toysArray() {
        Toy[] arrayOfToys = new Toy[_toysNumber];
        for (int i = 0; i < _toysNumber; i++) {
            arrayOfToys[i] = generateToy();
        }
        return arrayOfToys;
    }
}


