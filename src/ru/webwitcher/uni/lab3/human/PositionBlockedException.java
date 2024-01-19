package ru.webwitcher.uni.lab3.human;

public class PositionBlockedException extends RuntimeException {
    public PositionBlockedException() {
        super("Позиция человека заблокирована.");
    }
}
