package com.studyapp.PlayRoom.Toys.ToyStaff;

public class BuildingBricks extends Toy {
    // why static?
    static String[] _possibleNames = {"Lego Building Bricks", "BurgKids Building Bricks", "Panloss Building Bricks", "Garunk Building Bricks"};

    public BuildingBricks(String name, String size, double cost) {possibleNames = _possibleNames;
        init(size, cost, name);

    }
}

