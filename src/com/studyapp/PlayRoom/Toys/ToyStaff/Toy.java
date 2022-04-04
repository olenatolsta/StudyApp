package com.studyapp.PlayRoom.Toys.ToyStaff;

//Abstract toy characteristics
public abstract class Toy {
    //What should an access modifier be here for all variables?
    public double cost;
    public String name;
    public String size;
    public String[] possibleNames;

// TODO: add setters
    //remove useless default constructor
    public Toy() {
    }
    protected void init(String size, double cost, String name) {
        this.cost = cost;
        if (name == null)
            this.name=getRandomName();
        else this.name = name;
        this.size = size;
    }

    //What should an access modifier be here?
    public String getRandomName(){
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
