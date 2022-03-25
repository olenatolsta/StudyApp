package com.studyapp.PlayRoom.Toys;

public class ToyGenerator {
    /*
        1. создать прайс лист.
        1.1 сделать цикл от 0 до 50
        1.1.1 на каждом шаге цикла рандомно вьібрать тип создаваемой игрушки
        1.1.2 далее создать обьект вьібранного типа (свитч кейс)
        1.1.3 сгенерировать рандомно цену
        1.1.4 сгенерировать рандомно размер
        1.1.5 вьібрпать рандомно одно из названий игрушки используя статический метод класса игрушки
              в котором из статического массива имен будет вьібрано имя
        */

    //   1.1.1 On each step of the loop randomly choose a type of toy that should be created
    private static String randomToyType() {
        int n = 0;
        String toyType[] = {"BeachToys", "BuildingBricks", "DevToys", "StuffedToys", "Vehicles"};
        for (int i = 0; i < toyType.length; i++) {
            n = (int) (Math.random() * 5);
        }
        return toyType[n];
    }

    //Initialize the array with toys prices
    // 1.1.3 Randomly generate a price
    public static double getPrice() {
        double n = (int) (Math.random() * 15.23 + 5);
        return n;
    }

    //1.1.4 Randomly generate a size
    private static String getSize() {
        int n = 0;
        String toySize[] = {"Small", "Middle", "Big"};
        for (int i = 0; i < toySize.length; i++) {
            n = (int) (Math.random() * 3);
        }
        return toySize[n];
    }

    //1.1.2 Create an object of selected type (switch-case)
    public static Toy generateToy() {
        Toy toyObject;
        switch (randomToyType()) {
            case "BeachToys":
                toyObject = new BeachToys(null, getSize(), getPrice());
                break;
            case "StuffedToys":
                toyObject = new StuffedToys(null, getSize(), getPrice());
                break;
            case "BuildingBricks":
                toyObject = new BuildingBricks(null, getSize(), getPrice());
                break;
            case "DevToys":
                toyObject = new DevToys(null, getSize(), getPrice());
                break;
            case "Vehicles":
                toyObject = new Vehicles (null, getSize(), getPrice());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + randomToyType());
        }
        return toyObject;
    }

    //   1.1 Create a loop from 0 to toysNumber
    public static Toy[] toysArray(int toysNumber) {
        Toy[] arrayOfToys = new Toy[toysNumber];
        for (int i = 0; i < toysNumber; i++) {
            arrayOfToys[i] = generateToy();
        }
        return arrayOfToys;
    }
}


