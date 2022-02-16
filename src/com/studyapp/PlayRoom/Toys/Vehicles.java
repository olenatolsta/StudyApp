package com.studyapp.PlayRoom.Toys;

public class Vehicles extends Toy {
    static String[] _possibleNames = {"Pickup", "Truck", "Motorcycle", "Wagon"};

    public Vehicles(String name, String size, double cost) {possibleNames = _possibleNames;
        init(size, cost, name);

    }
}

