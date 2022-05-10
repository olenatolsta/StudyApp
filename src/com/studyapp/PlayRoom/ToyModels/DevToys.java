package com.studyapp.PlayRoom.ToyModels;

public class DevToys extends Toy {
    // why static? // [Olena] re-worked
    private String[] _possibleNames = {"Picture of a sand", "Knitting Set", "Embroidering Set", "Drawing set"};

    public DevToys(String name, String size, double cost) {
        possibleNames = _possibleNames;
        init(size, cost, name);
    }
}
