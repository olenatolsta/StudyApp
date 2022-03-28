package com.studyapp.PlayRoom.Toys.ToyStaff;

public class DevToys extends Toy {
    static String[] _possibleNames = {"Picture of a sand", "Knitting Set", "Embroidering Set", "Drawing set"};

    public DevToys(String name, String size, double cost) {possibleNames = _possibleNames;
        init(size, cost, name);

    }
}
