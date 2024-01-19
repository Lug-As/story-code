package ru.webwitcher.uni.lab3.furniture;

public class ResourceIsNotAvailableException extends Exception {
    public ResourceIsNotAvailableException() {
        super("Мест нет");
    }
}
