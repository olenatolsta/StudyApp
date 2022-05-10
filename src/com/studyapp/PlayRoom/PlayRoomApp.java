package com.studyapp.PlayRoom;

import com.studyapp.PlayRoom.Toys.Controller.Menu;

public class PlayRoomApp {

    public static void main(String[] args) {
        Menu menu = new Menu(50, 200);
        menu.availableOptions();
    }
}
