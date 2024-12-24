package Domain.Humans;

public enum HumanType {
    Amateur(1),
    Athlete(2);

    private final int value;

    HumanType(int value) {
        this.value = value;
    }

    /**
     *  Тип человека по значению.
     *
     * @param value значение категории.
     * @return категорию животного.
     */
    public static HumanType fromValue(int value) {
        for (HumanType type : HumanType.values()) {
            if (type.value == value) {
                return type;
            }
        }
        return null;
    }
}