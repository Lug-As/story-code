package ru.webwitcher.uni.lab3.scene;

import ru.webwitcher.uni.lab3.human.Human;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Location {
    private final String name;

    private Weather weather;

    private Location parentLocation;

    private final List<Human> characters = new ArrayList<>();

    public Location(String name) {
        this.name = name;
    }

    public Location(String name, Location parentLocation) {
        this(name);
        this.parentLocation = parentLocation;
    }

    public String getName() {
        return name;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
        characters.forEach(this::applyWeatherEntranceEffect);
    }

    private void applyWeatherEntranceEffect(Human human) {
        if (weather != null && weather.hasEffect()) {
            WeatherEffect effect = weather.getEffect();
            effect.applyEntranceEffect(human);
        }
    }

    private void applyWeatherExitEffect(Human human) {
        if (weather != null && weather.hasEffect()) {
            WeatherEffect effect = weather.getEffect();
            effect.applyExitEffect(human);
        }
    }

    public void addCharacter(Human human) {
        characters.add(human);
        applyWeatherEntranceEffect(human);
    }

    public void removeCharacter(Human human) {
        characters.remove(human);
        applyWeatherExitEffect(human);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Location location = (Location) o;
        return Objects.equals(name, location.name) && weather == location.weather && Objects.equals(parentLocation, location.parentLocation) && Objects.equals(characters, location.characters);
    }

    public int hashCode() {
        return Objects.hash(name, weather, parentLocation, characters);
    }
}
