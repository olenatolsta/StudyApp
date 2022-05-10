package com.studyapp.PlayRoom.ToyModels;

public class BuildingBricks extends Toy {
    // why static? // [Olena] re-worked
    private String[] _possibleNames = {"Lego Building Bricks", "BurgKids Building Bricks", "Panloss Building Bricks", "Garunk Building Bricks"};

    public BuildingBricks(String name, String size, double cost) {possibleNames = _possibleNames;
        init(size, cost, name);

    }
}

