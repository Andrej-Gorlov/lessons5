package Domain.Humans;

public class Amateur extends Human{
    private static final double RUN_FAST_SPEED = 9.0;
    private static final double RUN_SLOW_SPEED = 3.0;
    private static final double SWIM_FAST_SPEED = 1.5;
    private static final double SWIM_SLOW_SPEED = 0.5;

    public Amateur(String name) {
        super(name);
    }

    @Override
    public void runFast() {
        printSpeed("бежит быстро", RUN_FAST_SPEED);
    }

    @Override
    public void runSlowly() {
        printSpeed("бежит спокойно", RUN_SLOW_SPEED);
    }

    @Override
    public void swimFast() {
        printSpeed("плавает быстро", SWIM_FAST_SPEED);
    }

    @Override
    public void swimSlowly() {
        printSpeed("плавает спокойно", SWIM_SLOW_SPEED);
    }

    private void printSpeed(String action, double speed) {
        System.out.printf( name + ": " + action + " с скоростью " + speed + " км/ч\n");
    }
}
