package ru.webwitcher.uni.lab3.furniture;

import ru.webwitcher.uni.lab3.enums.Room;

public abstract class Furniture {
    private final Room room;

    public Furniture(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }
}
