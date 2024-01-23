package ru.webwitcher.uni.lab3.scene;

import ru.webwitcher.uni.lab3.human.Human;

public enum Weather {
    CLOUDY,
    RAINY(new WeatherEffect() {
        public void applyEntranceEffect(Human human) {
            if (!human.isProtectedFromGettingWet()) {
                human.getWet();
            }
        }

        public void applyExitEffect(Human human) {
            human.dryUp();
        }
    });

    private WeatherEffect effect;

    Weather() {
    }

    Weather(WeatherEffect effect) {
        this.effect = effect;
    }

    public WeatherEffect getEffect() {
        return effect;
    }

    public boolean hasEffect() {
        return effect != null;
    }
}
