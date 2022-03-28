package com.studyapp.PlayRoom.Toys.ToyStaff;

public class Vehicles extends Toy {
    static String[] _possibleNames = {"Pickup", "Truck", "Motorcycle", "Wagon"};

    public Vehicles(String name, String size, double cost) {possibleNames = _possibleNames;
        init(size, cost, name);
    }
}

