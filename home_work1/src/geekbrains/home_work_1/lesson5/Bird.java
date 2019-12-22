package geekbrains.home_work_1.lesson5;

public class Bird extends Animal {
    Bird(String name) {
        super("Bird", name, 1, 5, 1);
    }

    @Override
    protected int swim(float distance) {
        return Animal.SWIM_WTF;
    }
}
