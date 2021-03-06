package com.studyapp.PlayRoom;

import com.studyapp.PlayRoom.ToyModels.*;
import com.studyapp.PlayRoom.ToyModels.Toy;

public class ToyGenerator {
    /*
        1. создать прайс лист.
        1.1 сделать цикл от 0 до 50
        1.1.1 на каждом шаге цикла рандомно вьібрать тип создаваемой игрушки
        1.1.2 далее создать обьект вьібранного типа (свитч кейс)
        1.1.3 сгенерировать рандомно цену
        1.1.4 сгенерировать рандомно размер
        1.1.5 вьібрать рандомно одно из названий игрушки используя статический метод класса игрушки
              в котором из статического массива имен будет вьібрано имя
        */

    //   1.1.1 On each step of the loop randomly choose a type of toy that should be created
    //why static?
    private static String randomToyType() {
        //please add more readable variable - [Olena] changed
        int randNumber = 0;
        String toyType[] = {"BeachToys", "BuildingBricks", "DevToys", "StuffedToys", "Vehicles"};
        for (int i = 0; i < toyType.length; i++) {
            randNumber = (int) (Math.random() * 5);
        }
        return toyType[randNumber];
    }

    //Initialize the array with toys prices
    // 1.1.3 Randomly generate a price
    //why static? - [Olena] changed
    public double getPrice() {
        //useless variable - [Olena] Changed
        return (int) (Math.random() * 15.23 + 5);
    }

    //1.1.4 Randomly generate a size
    //why static? - [Olena] Changed
    private String getSize() {
        //please add more readable variable - [Olena] Changed
        int randNumber = 0;
        String toySize[] = {"Small", "Middle", "Big"};
        for (int i = 0; i < toySize.length; i++) {
            randNumber = (int) (Math.random() * 3);
        }
        return toySize[randNumber];
    }

    //1.1.2 Create an object of selected type (switch-case)
    //What should an access modifier be here? - [Olena] Changed o private
    //why static? - [Olena] Changed
    private Toy generateToy() {
        Toy toyObject;
        switch (randomToyType()) {
            case "BeachToys":
                //Why null parameter?

                //[Olena] This was done just in case we do not find a proper name in the array with names
                // refer to Toy.java - below is a peace of code from there
                /*protected void init(String size, double cost, String name) {
                this.cost = cost;
                if (name == null)
                    this.name=getRandomName();
                else this.name = name;
                this.size = size;*/

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
                toyObject = new Vehicles(null, getSize(), getPrice());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + randomToyType());
        }
        return toyObject;
    }

    //   1.1 Create a loop from 0 to toysNumber
    //why static? - [Olena] Changed
    public Toy[] toysArray(int toysNumber) {
        Toy[] arrayOfToys = new Toy[toysNumber];
        for (int i = 0; i < toysNumber; i++) {
            arrayOfToys[i] = generateToy();
        }
        return arrayOfToys;
    }
}


