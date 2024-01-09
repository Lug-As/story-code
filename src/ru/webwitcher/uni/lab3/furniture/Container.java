package ru.webwitcher.uni.lab3.furniture;

public interface Container<T> {
    void fill(T content);

    void empty();

    boolean isEmpty();
}
