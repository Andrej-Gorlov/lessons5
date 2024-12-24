Переписан проект с урока (вендинговый автомат) используя конструктор, перечисления и взаимодействие с пользователем.

- Реализован абстрактный класс Animal с абстрактными методами getName и performActions, а также полем category. Создано несколько классов животных Dolphin, Goose, Cheetah, которые наследуют класс Animal. Метод getName выводит название каждого животного, метод performActions выводит конкретные действия животного.

- Реализованы интерфейсы Flyable, Runnable, Swimmable в каждом реализовано по одному методу. Добавлена реализация этих интерфейсов в класс Animal из предыдущего задания. Некоторые животные реализуют больше одного интерфейса
(реализован паттерн “Фабричный метод”)

- Реализован абстрактный класс Human, реализующий интерфейсы Runner и Swimmer (в каждом по 2 метода). Реализовано несколько наследников этого класса с реализацией методов, объявленных в интерфейсах.
(реализован паттерн “Стратегия”)
