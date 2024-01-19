package ru.webwitcher.uni.lab3.human;

public record Dream(String essence) {
    public String toString() {
        return essence();
    }
}
