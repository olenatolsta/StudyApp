package com.studyapp.PlayRoom.Toys;

class ToysQtyCalculator {

    /*
    2. Посчитать максимальное кол-во игрушек с минимальной ценой, которое можно вместить в бюджет
    3. Посчитать минимальное кол-во игрушек с максимальной ценой, которое можно вместить в бюджет
    4. Вьічислить среднее арифметич, округлить до целого в меньшую сторону
    5. Значение из (4) будет искомьім количеством игрушек
     */

    private Toy[] catalog;
    private double budget;
    //Constructor
    ToysQtyCalculator(double _budget, Toy[] _catalog){
        budget = _budget;
        catalog = _catalog;
    }

    public double getBudget(){
        return budget;
    }

    public Toy[] getCatalog(){
        return catalog;
    }

    //Find a Toy with minimal price
    public Toy toyMinPrice() {
        Toy minElement = catalog[0];
        for (int i = 0; i < catalog.length; i++) {
            if (catalog[i].cost < minElement.cost) {
                minElement = catalog[i];
            }
        }
        return minElement;
    }

    public double minPriceQty() {
        double minPrice = toyMinPrice().cost;
        double minQty = budget / minPrice;
        return minQty;
    }

    //Find a Toy with max price
    public Toy toyMaxPrice() {
        Toy maxElement = toyMinPrice();
        for (int i = 0; i < catalog.length; i++) {
            if (catalog[i].cost > maxElement.cost) {
                maxElement = catalog[i];
            }
        }
        return maxElement;
    }

    public double maxPriceQty() {
        double maxPrice = toyMaxPrice().cost;
        double maxQty = budget / maxPrice;
        return maxQty;
    }

    public int averageQuantity() {
        double minQuantity = minPriceQty();
        double maxQuantity = maxPriceQty();
        int aveQ = (int) Math.round((minQuantity + maxQuantity)/3);
        return aveQ;
    }
}