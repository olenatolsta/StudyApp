package com.studyapp.PlayRoom.ToyModels;

//Abstract toy characteristics
public abstract class Toy {
    //What should an access modifier be here for all variables? // [Olena] re-worked
    private double cost;
    private String name;
    private String size;
    String[] possibleNames;

    //remove useless default constructor // [Olena] re-worked
    protected void init(String size, double cost, String name) {
        this.cost = cost;
        if (name == null)
            this.name=getRandomName();
        else this.name = name;
        this.size = size;
    }

    //What should an access modifier be here? [Olena] re-worked
    private String getRandomName(){
        int n= 0;
        for (int i = 0; i < possibleNames.length; i++) {
            n = (int) (Math.random() * possibleNames.length);
        }
        return possibleNames[n];
    }
    /*
    public Toy(String size, double cost, String name) {
        init(size, cost, name);
    }

    @Override
    public String toString() {
        return "( " + name + " : " + cost + " : " + size + ")";
    }

    /* public void setCost(double newCost) {
        this.cost = newCost;
    } */

    public double getCost() {
        return cost;
    }

    public String getSize() {
        return size;
    }

    public String getName() {
        return name;
    }
}
