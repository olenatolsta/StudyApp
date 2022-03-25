package com.studyapp.PlayRoom.Toys;

public class PlayRoomApp {

    public static void main(String[] args) {
        Toy[] toy = ToyGenerator.toysArray(50);
        ToysQtyCalculator toysQtyCalculator = new ToysQtyCalculator(200, toy);
        PlayRoom room = new PlayRoom(toysQtyCalculator);
        room.availableOptions();
    }
}
