package lab.food;

import lab.human.Human;

public class Borsch implements Food {
    public void digest(Human consumer) {
        consumer.addEnergy(40);
        consumer.addHealth(10);
    }
}
