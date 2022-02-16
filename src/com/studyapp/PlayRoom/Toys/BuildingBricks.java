package com.studyapp.PlayRoom.Toys;

public class BuildingBricks extends Toy {
    static String[] _possibleNames = {"Lego Building Bricks", "BurgKids Building Bricks", "Panloss Building Bricks", "Garunk Building Bricks"};

    public BuildingBricks(String name, String size, double cost) {possibleNames = _possibleNames;
        init(size, cost, name);

    }
}

