package Domain.Animals;

public enum AnimalCategory {
    OVERLAND(1), // Наземные
    BIRDS(2), // Воздушные
    AQUATIC(3); // Водные

    private final int value;

    AnimalCategory(int value) {
        this.value = value;
    }

    /**
     *  Категория животного по значению.
     *
     * @param value значение категории.
     * @return категорию животного.
     */
    public static AnimalCategory fromValue(int value) {
        for (AnimalCategory category : AnimalCategory.values()) {
            if (category.value == value) {
                return category;
            }
        }
        return null;
    }
}
