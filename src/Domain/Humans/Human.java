package Domain.Humans;

import Service.Interfaces.Human.Runner;
import Service.Interfaces.Human.Swimmer;

public abstract class Human implements Runner, Swimmer {
    protected String name;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
