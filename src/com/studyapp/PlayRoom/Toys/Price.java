package com.studyapp.PlayRoom.Toys;

public class Price {

    private final static String SOURCE_PATH = "price.txt";

    //class variable - field
    int _toysNumber = 50;

    //Constructor, which calls an array
    Price(int toysNumber) {
        _toysNumber = toysNumber;
        toysPrice();
    }

    //declare a variable, that's going to store the array
    double[] priceList;

    //Initialize the initial array
    public double[] toysPrice() {
        priceList = new double[_toysNumber];
        for (int i = 0; i < priceList.length; i++) {
            int n = (int) (Math.random() * 15.23 + 5);
            priceList[i] = n;
        }
        return priceList;
    }

    public static double getPrice() {
        double price = 0;
        return price;
    }

}

