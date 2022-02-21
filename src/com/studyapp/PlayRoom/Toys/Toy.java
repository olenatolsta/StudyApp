package com.studyapp.PlayRoom.Toys;

//Abstract toy characteristics
public abstract class Toy {
    public double cost;
    public String name;
    public String size;
    public String[] possibleNames;

// TODO: add setters
    public Toy() {

    }
    public void init(String size, double cost, String name) {
        this.cost = cost;
        if (name == null)
            this.name=getRandomName();
        else this.name = name;
        this.size = size;
    }
    public Toy(String size, double cost, String name) {
        init(size, cost, name);
    }

    @Override
    public String toString() {
        return "( " + name + " : " + cost + " : " + size + ")";
    }

    public double getCost() {
        return cost;
    }

    /* public void setCost(double newCost) {
        this.cost = newCost;
    } */

    public String getRandomName(){
        int n= 0;
        for (int i = 0; i < possibleNames.length; i++) {
            n = (int) (Math.random() * possibleNames.length);
        }
        return possibleNames[n];
    }

    public String getSize() {
        return size;
    }
}
