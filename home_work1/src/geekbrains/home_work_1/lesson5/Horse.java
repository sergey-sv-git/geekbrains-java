package geekbrains.home_work_1.lesson5;

public class Horse extends Animal {
    Horse(String name) {
        super("Horse", name, 0.5f, 1500, 1);
    }

    @Override
    protected int swim(float distance) {
        return Animal.SWIM_WTF;
    }
}
