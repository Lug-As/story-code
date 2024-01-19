package ru.webwitcher.uni.lab3.furniture;

import ru.webwitcher.uni.lab3.human.Human;

public class Coffin implements Container<Human> {
    private Human human = null;

    public void fill(Human content) {
        human = content;
    }

    public void empty() {
        human = null;
    }

    public boolean isEmpty() {
        return human == null;
    }
}
