package domain.animals.overland;

import domain.animals.Animal;
import domain.animals.AnimalCategory;
import service.interfaces.animal.Runnable;

public class Cheetah extends Animal implements Runnable {
    private final String name;

    public Cheetah() {
        super(AnimalCategory.OVERLAND);
        this.name = "Гепард";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void performActions() {
        run();
        hunt();
    }

    @Override
    public void run() {
        System.out.println(name + " бежит.");
    }

    public void hunt(){
        System.out.println(name + " охотится.");
    }
}
