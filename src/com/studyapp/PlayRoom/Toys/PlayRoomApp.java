package com.studyapp.PlayRoom.Toys;

public class PlayRoomApp {

    public static void main(String[] args) {
        Toy[] toy = ToyGenerator.toysArray(8);
        ToysQtyCalculator toysQtyCalculator = new ToysQtyCalculator(50, toy);
        PlayRoom room = new PlayRoom(toysQtyCalculator);
        room.availableOptions();
    }
}
