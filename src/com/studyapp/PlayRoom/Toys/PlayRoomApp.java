package com.studyapp.PlayRoom.Toys;

public class PlayRoomApp {
    static Toy[] toys = new Toy[3];

    public static void main(String[] args) {
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

        /*for (int i = 0; i < 3; i++) {
            System.out.println(toys[i].name + " " + toys[i].size);
        }*/
        ToyGenerator bb = new ToyGenerator(40);
        Toy[] xxx = bb.toysArray();
    }
}
