package output;

import domain.MenuType;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class BaseMenu {
    protected final Scanner scn;

    protected void cloceScanner(){
        this.scn.close();
    }

    public BaseMenu(){
        this.scn = new Scanner(System.in);
    }

    protected int getUserChoice(MenuType type) {
        while (true) {
            try {
                switch (type) {
                    case Default:
                        menuDefault();
                        break;
                    case Animal:
                        menuAnimal();
                        break;
                    case Human:
                        menuHuman();
                        break;
                    default:
                        System.out.println("Некорректный выбор. Попробуйте снова.");
                }
                return this.scn.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введите целое число.");
                this.scn.next(); // Очистка неверного ввода
            }
        }
    }

    private  void menuDefault(){
        System.out.println("\n Выберите какой класс создать.");
        System.out.println(" 1) Животное");
        System.out.println(" 2) Человек");
        System.out.println(" 0) Выход \n");
    }

    private void menuAnimal(){
        System.out.println("\n Выберите категорию: ");
        System.out.println(" 1) Наземные");
        System.out.println(" 2) Воздушные");
        System.out.println(" 3) Водные");
        System.out.println(" 0) Вернуться назад \n");
    }

    private void menuHuman(){
        System.out.println("\n Выберите категорию: ");
        System.out.println(" 1) Спортсмен");
        System.out.println(" 2) Любитель");
        System.out.println(" 0) Вернуться назад \n");
    }
}
