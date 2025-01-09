package service.implementations;

import service.interfaces.human.Runner;
import service.interfaces.human.Swimmer;
import service.interfaces.human.Participant;
import java.util.Optional;

public class HumanStrategy {

    // Контейнер наследников Participant
    private Optional<Participant> participant = Optional.empty();

    public void setParticipant(Participant participant) {
        this.participant = Optional.ofNullable(participant);
    }

    // Запуск бега
    public void performRun() {
        participant.ifPresentOrElse(
                runner -> {
                    if (runner instanceof Runner) {
                        try {
                            executeRunning((Runner) runner);
                        } catch (Exception e) {
                            System.out.println("Ошибка при выполнении бега: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Участник не является бегуном.");
                    }
                },
                () -> System.out.println("Участник не определен.")
        );
    }

    // Запуск плавания
    public void performSwim() {
        participant.ifPresentOrElse(
                swimmer -> {
                    if (swimmer instanceof Swimmer) {
                        try {
                            executeSwimming((Swimmer) swimmer);
                        } catch (Exception e) {
                            System.out.println("Ошибка при выполнении плавания: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Участник не является пловцом.");
                    }
                },
                () -> System.out.println("Участник не определен.")
        );
    }

    /**
     * Выполнение бега.
     *
     * @param runner экземпляр класса.
     * @throws IllegalArgumentException недопустимое состояние или параметр.
     * @throws Exception ошибка при выполнении бега.
     */
    private void executeRunning(Runner runner) throws Exception {
        try {
            runner.runFast();
        } catch (IllegalArgumentException e) {
            throw new Exception("Ошибка при быстром беге: " + e.getMessage());
        }

        try {
            runner.runSlowly();
        } catch (IllegalArgumentException e) {
            throw new Exception("Ошибка при медленном беге: " + e.getMessage());
        }
    }

    /**
     * Выполнение плавания.
     *
     * @param swimmer экземпляр класса.
     * @throws IllegalArgumentException недопустимое состояние или параметр.
     * @throws Exception ошибка при выполнении плавания.
     */
    private void executeSwimming(Swimmer swimmer) throws Exception {
        try {
            swimmer.swimFast();
        } catch (IllegalArgumentException e) {
            throw new Exception("Ошибка при быстром плавании: " + e.getMessage());
        }

        try {
            swimmer.swimSlowly();
        } catch (IllegalArgumentException e) {
            throw new Exception("Ошибка при медленном плавании: " + e.getMessage());
        }
    }
}
