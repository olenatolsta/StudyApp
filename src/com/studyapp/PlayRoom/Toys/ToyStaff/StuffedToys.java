package com.studyapp.PlayRoom.Toys.ToyStaff;

public class StuffedToys extends Toy {
    static String[] _possibleNames = {"Stuffed Puppy", "Stuffed Teethless", "Stuffed Cat", "Stuffed Bear"};

    public StuffedToys(String name, String size, double cost) {possibleNames = _possibleNames;
        init(size, cost, name);
    }
}

