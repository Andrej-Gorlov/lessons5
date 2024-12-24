package Service.Helpers;

import Domain.Animals.Animal;
import Domain.Animals.AnimalCategory;
import Domain.Animals.Aquatic.Dolphin;
import Domain.Animals.Birds.Goose;
import Domain.Animals.Overland.Cheetah;
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
