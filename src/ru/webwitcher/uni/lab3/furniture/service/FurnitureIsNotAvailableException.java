package ru.webwitcher.uni.lab3.furniture.service;

import ru.webwitcher.uni.lab3.furniture.Furniture;
import ru.webwitcher.uni.lab3.human.Human;

public class FurnitureIsNotAvailableException extends RuntimeException {
    public FurnitureIsNotAvailableException(Furniture furniture, Human human) {
        super("У человека %s нет доступа к мебели %s. Текущая локация - %s, необходимая локация - %s".formatted(
                human.getName(),
                furniture.getClass().getSimpleName(),
                human.getLocation().getName(),
                furniture.getLocation().getName()
        ));
    }
}
