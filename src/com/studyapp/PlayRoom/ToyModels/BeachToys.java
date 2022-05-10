package com.studyapp.PlayRoom.ToyModels;

public class BeachToys extends Toy {
    // why static? // [Olena] re-worked
    private String[] _possibleNames = {"Bucket", "Scoop", "Rake", "Sieve"};

    public BeachToys(String name, String size, double cost) {
        possibleNames = _possibleNames;
        init(size, cost, name);
    }
}
