package Domain.Animals;

abstract public class Animal {
    public abstract String getName();
    public AnimalCategory category;
    public abstract void performActions(); // Конкретные действия животного.

    public Animal(AnimalCategory type) {
        this.category = type;
    }
}
