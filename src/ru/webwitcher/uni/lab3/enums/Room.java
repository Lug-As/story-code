package ru.webwitcher.uni.lab3.enums;

import java.util.Objects;

public class Room {
    private final String name;

    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Room room = (Room) o;
        return Objects.equals(name, room.name);
    }

    public int hashCode() {
        return Objects.hash(name);
    }
}
