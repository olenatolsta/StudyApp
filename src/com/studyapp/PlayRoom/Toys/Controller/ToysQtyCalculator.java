package com.studyapp.PlayRoom.Toys.Controller;

import com.studyapp.PlayRoom.ToyModels.Toy;

class ToysQtyCalculator {

    /*
    2. Посчитать максимальное кол-во игрушек с минимальной ценой, которое можно вместить в бюджет
    3. Посчитать минимальное кол-во игрушек с максимальной ценой, которое можно вместить в бюджет
    4. Вьічислить среднее арифметич, округлить до целого в меньшую сторону
    5. Значение из (4) будет искомьім количеством игрушек
     */

    private final Toy[] catalog;//should be final - [Olena] Changed to final
    private final double budget;//should be final - [Olena] Changed to final
    //Constructor
    ToysQtyCalculator(double tbudget, Toy[] tcatalog){
        budget = tbudget;
        catalog = tcatalog;
    }

    public double getBudget(){
        return budget;
    }

    public Toy[] getCatalog(){
        return catalog;
    }

    //Find a Toy with minimal price
    //What should an access modifier be here? - [Olena] Changed to default
    Toy toyMinPrice() {
        Toy minElement = catalog[0];
        //other option for 'for' loop - [Olena] Changed to foreach
        for (Toy i : catalog) {
            if (i.getCost() < minElement.getCost()) {
                minElement = i;
            }
        }
        return minElement;
    }

    //What should an access modifier be here?
    private double minPriceQty() {
        //useless variable - [Olena] Changed
        return budget /toyMinPrice().getCost();
    }

    //Find a Toy with max price
    //What should an access modifier be here? - [Olena] Changed to default
    private Toy toyMaxPrice() {
        Toy maxElement = toyMinPrice();
        //other option for 'for' loop - [Olena] Changed to foreach
        for (Toy i : catalog) {
            if (i.getCost() > maxElement.getCost()) {
                maxElement = i;
            }
        }
        return maxElement;
    }
    //What should an access modifier be here? [Olena] Changed to private
    private double maxPriceQty() {
        //useless variable - [Olena] Changed
        return budget/toyMaxPrice().getCost();
    }

    //What should an access modifier be here? [Olena] Changed to default
    int averageQuantity() {
        //useless variable - [Olena] Changed
        return (int) Math.round((minPriceQty() + maxPriceQty())/4);
    }
}