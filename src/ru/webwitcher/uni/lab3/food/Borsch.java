package ru.webwitcher.uni.lab3.food;

import ru.webwitcher.uni.lab3.human.Human;

public class Borsch implements Food {
    public void digest(Human consumer) {
        consumer.addEnergy(40);
        consumer.addHealth(10);
    }
}
