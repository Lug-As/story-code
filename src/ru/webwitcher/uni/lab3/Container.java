package ru.webwitcher.uni.lab3;

public interface Container<T> {
    void fill(T content);

    void empty();

    boolean isEmpty();
}
