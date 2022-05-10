package com.studyapp.PlayRoom.ToyModels;

public class Vehicles extends Toy {
    // why static? // [Olena] re-worked
    private String[] _possibleNames = {"Pickup", "Truck", "Motorcycle", "Wagon"};

    public Vehicles(String name, String size, double cost) {possibleNames = _possibleNames;
        init(size, cost, name);
    }
}

