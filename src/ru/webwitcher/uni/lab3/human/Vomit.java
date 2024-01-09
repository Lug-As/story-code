package ru.webwitcher.uni.lab3.human;

import ru.webwitcher.uni.lab3.food.Food;

public class Vomit {
    private final Food structure;

    public Vomit(Food structure) {
        this.structure = structure;
    }

    public Food getStructure() {
        return structure;
    }
}
