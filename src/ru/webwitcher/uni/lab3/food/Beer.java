package ru.webwitcher.uni.lab3.food;

import ru.webwitcher.uni.lab3.human.Human;

public class Beer implements Food {
    public void digest(Human consumer) {
        if (consumer.getAlcoholLevel() < 0.6f) {
            consumer.addEnergy(10);
        } else {
            consumer.addEnergy(-20);
        }
        consumer.addHealth(-10);
        consumer.addAlcoholLevel(0.3f);
    }
}
