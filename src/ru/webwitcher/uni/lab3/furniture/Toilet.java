package ru.webwitcher.uni.lab3.furniture;

import ru.webwitcher.uni.lab3.enums.Room;
import ru.webwitcher.uni.lab3.human.Human;

public class Toilet extends Furniture {
    private Object container = null;

    public Toilet(Room room) {
        super(room);
    }

    public Object getContainer() {
        return container;
    }

    public void fill(Human user, Object object) {
        checkLocation(user);
        container = object;
    }

    public void flush(Human user) {
        checkLocation(user);
        container = null;
        System.gc();
    }
}
