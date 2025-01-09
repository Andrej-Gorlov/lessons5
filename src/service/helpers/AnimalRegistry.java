package service.helpers;

import domain.animals.Animal;
import domain.animals.AnimalCategory;
import domain.animals.aquatic.Dolphin;
import domain.animals.birds.Goose;
import domain.animals.overland.Cheetah;
import java.util.HashMap;
import java.util.Map;

public class AnimalRegistry {
    private static final Map<AnimalCategory, Class<? extends Animal>> animalClasses = new HashMap<>();

    static {
        animalClasses.put(AnimalCategory.OVERLAND, Cheetah.class);
        animalClasses.put(AnimalCategory.BIRDS, Goose.class);
        animalClasses.put(AnimalCategory.AQUATIC, Dolphin.class);
    }

    public static Class<? extends Animal> getAnimalClass(AnimalCategory type) {
        return animalClasses.get(type);
    }
}
