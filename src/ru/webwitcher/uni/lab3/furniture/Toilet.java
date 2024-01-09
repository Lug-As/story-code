package ru.webwitcher.uni.lab3.furniture;

import ru.webwitcher.uni.lab3.Container;
import ru.webwitcher.uni.lab3.enums.Room;

public class Toilet extends Furniture implements Container<Object> {
    private Object content = null;

    public Toilet(Room room) {
        super(room);
    }

    public Object getContent() {
        return content;
    }

    public void fill(Object o) {
        content = o;
    }

    public void empty() {
        content = null;
        System.gc();
    }

    public boolean isEmpty() {
        return content == null;
    }
}
