package domain.animals.birds;

import domain.animals.Animal;
import domain.animals.AnimalCategory;
import service.interfaces.animal.Flyable;
import service.interfaces.animal.Runnable;
import service.interfaces.animal.Swimmable;

public class Goose extends Animal implements Flyable, Runnable, Swimmable {
    private final String name;

    public Goose() {
        super(AnimalCategory.BIRDS);
        this.name = "Гусь";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void performActions() {
        fly();
        run();
        swim();
    }

    @Override
    public void fly() {
        System.out.println(name + " летит.");
    }

    @Override
    public void run() {
        System.out.println(name + " бежит.");
    }

    @Override
    public void swim() {
        System.out.println(name + " плавает.");
    }
}