package domain.animals.aquatic;

import domain.animals.Animal;
import domain.animals.AnimalCategory;
import service.interfaces.animal.Swimmable;

public class Dolphin extends Animal implements Swimmable {
    private final String name;

    public Dolphin() {
        super(AnimalCategory.AQUATIC);
        this.name = "Дельфин";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void performActions() {
        swim();
        useEcholocation();
    }

    @Override
    public void swim() {
        System.out.println(name + " плавает.");
    }

    public void useEcholocation(){
        System.out.println(name + " используют эхолокацию.");
    }
}
