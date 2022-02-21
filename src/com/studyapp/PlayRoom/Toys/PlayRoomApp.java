package com.studyapp.PlayRoom.Toys;

public class PlayRoomApp {

    public static void main(String[] args) {
        Toy[] toy = ToyGenerator.toysArray(50);
        PlayRoom room = new PlayRoom(toy);
        room.addToy(10);
    }
}
