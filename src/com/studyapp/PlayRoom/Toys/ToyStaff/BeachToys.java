package com.studyapp.PlayRoom.Toys.ToyStaff;

public class BeachToys extends Toy {
    static String[] _possibleNames = {"Bucket", "Scoop", "Rake", "Sieve"};

    public BeachToys(String name, String size, double cost) {
        possibleNames = _possibleNames;
        init(size, cost, name);
    }
}
