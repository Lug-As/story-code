package ru.webwitcher.uni.lab3.furniture;

public class ResourceIsNotAvailableException extends Exception {
    public ResourceIsNotAvailableException(Object resource) {
        super("Достигнут лимит пользователей ресурса: " + resource.toString());
    }
}
