package com.studyapp.PlayRoom.ToyModels;

public class StuffedToys extends Toy {
    // why static? // [Olena] re-worked
    private String[] _possibleNames = {"Stuffed Puppy", "Stuffed Teethless", "Stuffed Cat", "Stuffed Bear"};

    public StuffedToys(String name, String size, double cost) {
        possibleNames = _possibleNames;
        init(size, cost, name);
    }
}

