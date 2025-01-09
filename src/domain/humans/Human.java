package domain.humans;

import service.interfaces.human.Runner;
import service.interfaces.human.Swimmer;

public abstract class Human implements Runner, Swimmer {
    protected String name;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
