package Service.Implementations;

import Domain.Animals.Animal;
import Domain.Animals.AnimalCategory;
import Service.Helpers.AnimalRegistry;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class AnimalFactory {

    //использование рефлексии
    /**
     * Создание животных.
     *
     * @param type тип животного.
     * @return список животных.
     * @throws InstantiationException не создался экземпляр.
     * @throws IllegalAccessException доступ к конструктору запрещен.
     * @throws InvocationTargetException ошибка вызова конструктора.
     * @throws NoSuchMethodException отсутствует подходящий конструктор.
     */
    public static List<Animal> createAnimals(AnimalCategory type) {
        List<Animal> animals = new ArrayList<>();

        // Получаем класс животного по типу
        Class<? extends Animal> animalClass = AnimalRegistry.getAnimalClass(type);

        if (animalClass != null) {
            try {
                animals.add(animalClass.getDeclaredConstructor().newInstance());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                System.err.println("Ошибка при создании животного: " + e.getMessage());
            }
        }
        return animals;
    }
}
