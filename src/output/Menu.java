package output;

import domain.animals.Animal;
import domain.animals.AnimalCategory;
import domain.humans.Amateur;
import domain.humans.Athlete;
import domain.humans.HumanType;
import domain.MenuType;
import service.implementations.AnimalFactory;
import service.implementations.HumanStrategy;
import service.interfaces.human.Participant;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;

public class Menu extends BaseMenu{
    public void display(){

        while (true) {

            int choice = getUserChoice(MenuType.Default);

            switch (choice) {
                case 1:
                    displayAnimal();
                    break;
                case 2:
                    displayHuman();
                    break;
                case 0:
                    cloceScanner();
                    return;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }

    //region displaysAnimal
    /**
     * Отображение меню выбора категории животных.
     *
     * @throws NullPointerException объект равен null.
     * @throws Exception непредвиденная ошибка.
     */
    private void displayAnimal(){
        scn.nextLine();

        try {
            while (true) {
                int choice = getUserChoice(MenuType.Animal);
                AnimalCategory category = AnimalCategory.fromValue(choice);

                if (category != null) {
                    List<Animal> animals = AnimalFactory.createAnimals(category);
                    displayAnimalActions(animals);
                } else if (choice == 0) {
                    return;
                } else {
                    System.out.println("Некорректный выбор. Попробуйте снова.");
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }
    }

    /**
     * Отображение действий животных.
     *
     * @param animals Список животных.
     */
    private void displayAnimalActions(List<Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal.getName());
            animal.performActions();
        }
    }
    //endregion

    //region displayHuman
    /**
     * Отображение меню выбора типа людей.
     *
     * @throws InputMismatchException ввод некорректных данных.
     * @throws NoSuchElementException нет доступных ввода данных.
     * @throws Exception непредвиденная ошибка.
     */
    private void displayHuman() {
        scn.nextLine();
        HumanStrategy human = new HumanStrategy();

        try {
            while (true) {
                int choice = getUserChoice(MenuType.Human);
                if (choice == 0) return;

                scn.nextLine();
                System.out.print("Введите имя: ");
                String name = scn.nextLine();

                // Обработка выбора участника
                HumanType humanType = HumanType.fromValue(choice);
                if (humanType == null) {
                    System.out.println("Некорректный выбор. Попробуйте снова.");
                    return;
                }

                processParticipant(human, createParticipant(humanType, name));
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода. Пожалуйста, введите корректное значение.");
            scn.next(); // Очистка некорректного ввода
        } catch (NoSuchElementException e) {
            System.out.println("Ошибка: нет доступных данных для ввода. Проверьте источник ввода.");
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }
    }

    /**
     * Создает объект.
     *
     * @param humanType тип участника
     * @param name имя участника
     * @return созданный объект
     */
    private Participant createParticipant(HumanType humanType, String name) {
        switch (humanType) {
            case Athlete:
                return new Athlete(name);
            case Amateur:
                return new Amateur(name);
            default:
                throw new IllegalArgumentException("Некорректный тип участника: " + humanType);
        }
    }

    /**
     * Обработка возможностей.
     *
     * @param human объект стратегии
     * @param participant объект человека
     */
    private void processParticipant(HumanStrategy human, Participant participant) {
        human.setParticipant(participant);
        human.performRun();
        human.performSwim();
    }
    //endregion
}
