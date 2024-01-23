package ru.webwitcher.uni.lab3.scene;

import ru.webwitcher.uni.lab3.human.Human;

public interface WeatherEffect {
    void applyEntranceEffect(Human human);

    void applyExitEffect(Human human);
}
