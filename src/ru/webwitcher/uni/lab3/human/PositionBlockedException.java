package ru.webwitcher.uni.lab3.human;

public class PositionBlockedException extends RuntimeException {
    public PositionBlockedException(Human human) {
        super("Позиция человека по имени " + human.getName() + " заблокирована.");
    }
}
