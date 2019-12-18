package geekbrains.home_work_1.lesson5;

public class Horse extends Animal {
    final int lengthMaxRun = 1500;
    private int lengthMaxSwim;
    final double heightMax = 0.5;

    public Horse(String name){
        super(name);
    }
    public void setLengthMaxSwim(int lengthMaxSwim){
        this.lengthMaxSwim = lengthMaxSwim;
    }
    public int getLengthMaxSwim(){
        return this.lengthMaxSwim;
    }
    @Override
    public String run(int length) {
        if (length <= lengthMaxRun)
            return name + " пробежал " + length + " метров!";
        else return "Слишком далеко!";
    }
    @Override
    public String swim(int length) {
        if (length <= this.getLengthMaxSwim())
            return name + " проплыл " + length + " метров!";
        else return "Слишком далеко, пёсик " + name + " утонул(";

    }
    @Override
    public String highJump(double height) {
        if (height <= heightMax)
            return name + " прыгнул вверх на " + height + " метров!";
        else return "Слишком высоко!";
    }
}
