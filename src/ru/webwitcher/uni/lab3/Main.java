package ru.webwitcher.uni.lab3;

import ru.webwitcher.uni.lab3.enums.Emotion;
import ru.webwitcher.uni.lab3.enums.ImpossiblePromise;
import ru.webwitcher.uni.lab3.enums.PhysicalPosition;
import ru.webwitcher.uni.lab3.enums.Weather;
import ru.webwitcher.uni.lab3.food.Beer;
import ru.webwitcher.uni.lab3.furniture.*;
import ru.webwitcher.uni.lab3.furniture.service.BedService;
import ru.webwitcher.uni.lab3.furniture.service.MirrorService;
import ru.webwitcher.uni.lab3.furniture.service.ToiletService;
import ru.webwitcher.uni.lab3.human.Dream;
import ru.webwitcher.uni.lab3.human.Human;
import ru.webwitcher.uni.lab3.scene.Location;
import ru.webwitcher.uni.lab3.scene.Scene;
import ru.webwitcher.uni.lab3.thing.Color;
import ru.webwitcher.uni.lab3.thing.Umbrella;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Human luis = new Human("Луис");
        luis.consume(new Beer());

        List<Dream> dreams = luis.getDreams();
        dreams.add(new Dream("Поехать в лагерь Агаван"));
        dreams.add(new Dream("Обратиться в католичество"));
        dreams.add(new Dream("Поступить в колледж"));
        dreams.add(new Dream("Выиграть олимпийскую медаль"));

        Location street = new Location("Улица");
        street.setWeather(Weather.RAINY);
        Location house = new Location("Дом", street);
        Location bedroom = new Location("Спальня", house);
        Location bathroom = new Location("Ванная", house);

        Bed bed = new Bed(bedroom);
        Toilet toilet = new Toilet(bathroom);
        Mirror mirror = new Mirror(bathroom);

        BedService bedService = new BedService(bed);
        ToiletService toiletService = new ToiletService(toilet);
        MirrorService mirrorService = new MirrorService(mirror);

        Human rachel = new Human("Рэчел");
        rachel.goTo(bathroom);
        mirrorService.coverMirror(rachel);
        rachel.goTo(street);

        luis.goTo(bedroom);
        try {
            bedService.lieDownOnBed(luis);
        } catch (ResourceIsNotAvailableException e) {
            throw new RuntimeException(e.getMessage());
        }
        luis.sleep();

        Random random = new Random();

        LocalDateTime firstDay = LocalDateTime.of(1982, 10, 13, 7, 12);

        Scene firstDayScene = new Scene(currentScene -> {
            currentScene.setDateTime(firstDay);
            luis.cry();
            luis.awake();
            luis.setHealth(15);
            luis.setEnergy(10);
            bedService.getUpFromBed(luis);

            luis.goTo(bathroom);
            luis.setPhysicalPosition(PhysicalPosition.KNELT);

            try {
                toiletService.occupyToilet(luis);
            } catch (ResourceIsNotAvailableException e) {
                throw new RuntimeException(e.getMessage());
            }
            toiletService.fillToilet(luis, luis.threwUp());
            while (luis.getEnergy() < 5) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    break;
                }
                if (random.nextBoolean()) {
                    luis.addEnergy(1);
                }
            }
            luis.setPhysicalPosition(PhysicalPosition.STANDING);

            toiletService.flushToilet(luis);
            toiletService.freeToilet(luis);
            boolean result = mirrorService.lookInMirror(luis);
            if (!result) {
                luis.setCurrentEmotion(Emotion.SAD);
            }
            mirrorService.uncoverMirror(luis);

            luis.goTo(bedroom);
            try {
                bedService.lieDownOnBed(luis);
            } catch (ResourceIsNotAvailableException e) {
                throw new RuntimeException(e.getMessage());
            }
            luis.promise(ImpossiblePromise.STOP_DRINKING_BEER);
            luis.setCurrentEmotion(Emotion.DEPRESSIVE);
            try {
                bedService.sitDownOnBed(luis);
            } catch (ResourceIsNotAvailableException e) {
                throw new RuntimeException(e.getMessage());
            }
            for (int i = dreams.size() - 1; i >= 0; i--) {
                Dream dream = dreams.get(i);
                System.out.println(dream + " не получится");
                dreams.remove(dream);
            }
            luis.setEnergy(0);
        });

        firstDayScene.play();

        Human gage = new Human("Gage");
        gage.die();

        Coffin coffin = new Coffin();
        coffin.fill(gage);
        Grave grave = new Grave();
        grave.fill(coffin);

        Location cemetery = new Location("Кладбище");

        bedService.getUpFromBed(luis);
        luis.goTo(cemetery);
        rachel.goTo(cemetery);
        gage.goTo(cemetery);

        Human irvin = new Human("Ирвин");
        irvin.goTo(cemetery);
        Human funeralDirector = new Human("Директор похоронного бюро");
        funeralDirector.goTo(cemetery);

        Umbrella umbrella1 = new Umbrella(Color.BLACK);
        Umbrella umbrella2 = new Umbrella(Color.BLACK);
        Umbrella umbrella3 = new Umbrella(Color.BLACK);

        umbrella1.open();
        umbrella2.open();
        umbrella3.open();

        luis.getThings().add(umbrella1);
        rachel.getThings().add(umbrella2);
        funeralDirector.getThings().add(umbrella3);

        cemetery.setWeather(Weather.RAINY);

        Scene secondDayScene = new Scene(currentScene -> {
            currentScene.setDateTime(firstDay.plusDays(1).toLocalDate().atTime(14, 0));
            cemetery.setWeather(Weather.CLOUDY);

            umbrella1.close();
            umbrella2.close();
            umbrella3.close();

            funeralDirector.say("Пустите детей и не препятствуйте им приходить ко мне...");

            Location nearGrave = new Location("Возле могилы", cemetery);
            luis.goTo(nearGrave);

            grave.coverUp();
        });

        secondDayScene.play();
    }
}