package geekbrains.home_work_1.lesson5;

public class Cat extends Animal {

    Cat(String name) {
        super("Cat", name, 2, 200, 1);
    }

    @Override
    protected int swim(float distance) {
        return Animal.SWIM_WTF;
    }
}
