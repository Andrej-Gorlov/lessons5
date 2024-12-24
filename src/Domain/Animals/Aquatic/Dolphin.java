package Domain.Animals.Aquatic;

import Domain.Animals.Animal;
import Domain.Animals.AnimalCategory;
import Service.Interfaces.Animal.Swimmable;

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
