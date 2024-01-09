package ru.webwitcher.uni.lab3.furniture;

import ru.webwitcher.uni.lab3.enums.Room;
import ru.webwitcher.uni.lab3.human.Human;

public abstract class Furniture {
    private final Room room;

    public Furniture(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    protected void checkLocation(Human user) {
        if (!user.getLocation().equals(room)) {
            throw new RuntimeException("Нет доступа к мебели - не та комната.");
        }
    }
}
