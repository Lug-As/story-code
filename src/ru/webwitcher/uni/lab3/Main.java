package ru.webwitcher.uni.lab3;

import ru.webwitcher.uni.lab3.enums.Emotion;
import ru.webwitcher.uni.lab3.enums.ImpossiblePromise;
import ru.webwitcher.uni.lab3.enums.PhysicalPosition;
import ru.webwitcher.uni.lab3.enums.Room;
import ru.webwitcher.uni.lab3.food.Beer;
import ru.webwitcher.uni.lab3.furniture.Bed;
import ru.webwitcher.uni.lab3.furniture.Mirror;
import ru.webwitcher.uni.lab3.furniture.Toilet;
import ru.webwitcher.uni.lab3.human.Dream;
import ru.webwitcher.uni.lab3.human.Human;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Human luis = new Human("Луис");
        luis.consume(new Beer());

        List<Dream> dreams = luis.getDreams();
        dreams.add(new Dream("Поехать в лагерь Агаван"));
        dreams.add(new Dream("Обратиться в католичество"));
        dreams.add(new Dream("Поступить в колледж"));
        dreams.add(new Dream("Выиграть олимпийскую медаль"));

        Room bedroom = new Room("Спальня");
        Room bathroom = new Room("Ванная");

        Bed bed = new Bed(bedroom);
        Toilet toilet = new Toilet(bathroom);
        Mirror mirror = new Mirror(bathroom);

        Human rachel = new Human("Рэчел");
        rachel.goTo(bathroom);
        mirror.cover(rachel);
        rachel.goTo(null);

        luis.goTo(bedroom);
        bed.lieDownOn(luis);
        luis.sleep();

        Random random = new Random();

        /////////////

        luis.cry();
        luis.awake();
        luis.setHealth(15);
        luis.setEnergy(10);
        bed.getUp(luis);

        luis.goTo(bathroom);
        luis.setPhysicalPosition(PhysicalPosition.KNELT);
        toilet.fill(luis, luis.threwUp());
        while (luis.getEnergy() < 5) {
            Thread.sleep(100);
            if (random.nextBoolean()) {
                luis.addEnergy(1);
            }
        }
        luis.setPhysicalPosition(PhysicalPosition.STANDING);

        toilet.flush(luis);
        boolean result = mirror.lookIn(luis);
        if (!result) {
            luis.setCurrentEmotion(Emotion.SAD);
        }

        luis.goTo(bedroom);
        bed.lieDownOn(luis);
        luis.promise(ImpossiblePromise.STOP_DRINKING_BEER);
        luis.setCurrentEmotion(Emotion.DEPRESSIVE);
        bed.sitDownOn(luis);
        for (int i = dreams.size() - 1; i >= 0; i--) {
            Dream dream = dreams.get(i);
            System.out.println(dream + " не получится");
            dreams.remove(dream);
        }
        luis.setEnergy(0);
        System.out.println("End");
    }
}