package geekbrains.home_work_1.lesson5;

public class Bird extends Animal {
    final int lengthMaxRun = 5;
    private double heightMax;

    public Bird(String name, double heightMax){
        super(name);
        this.heightMax = heightMax;
    }
    @Override
    public String run(int length) {
        if (length <= lengthMaxRun)
            return name + " пробежал " + length + " метров!";
        else return "Слишком далеко!";
    }
    @Override
    public String highJump(double height) {
        if (height <= heightMax)
            return name + " прыгнул вверх на " + height + " метров!";
        else return "Слишком высоко!";

    }
}
