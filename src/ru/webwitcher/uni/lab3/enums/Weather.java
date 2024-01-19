package ru.webwitcher.uni.lab3.enums;

public enum Weather {
    SUNNY,
    CLOUDY,
    RAINY(human -> {
        if (!human.isProtectedFromGettingWet()) {
            human.getWet();
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
