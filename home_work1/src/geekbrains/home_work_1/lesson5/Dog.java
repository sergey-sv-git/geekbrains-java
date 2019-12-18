package geekbrains.home_work_1.lesson5;

public class Dog extends Animal {
    private int lengthMaxRun;
    private final int lengthMaxSwim = 10;
    final double heightMax = 0.5;

    public Dog(String name, int lengthMaxRun){
        super(name);
        this.lengthMaxRun = lengthMaxRun;
    }
    @Override
    public String run(int length) {
        if (length <= lengthMaxRun)
            return name + " пробежал " + length + " метров!";
        else return "Слишком далеко, пёсик "+name+" сдох(";
    }
    @Override
    public String swim(int length) {
        if (length <= lengthMaxSwim)
            return name + " проплыл " + length + " метров!";
        else return "Слишком далеко, пёсик " + name + " утонул(";
    }
    @Override
    public String highJump(double height) {
        if (height <= heightMax)
            return name + " прыгнул вверх на " + height + " метров!";
        else return "Слишком высоко, пёсик не допрыгнул.";
    }
}
