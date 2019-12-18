package geekbrains.home_work_1.lesson5;

public class Cat extends Animal {
    final int lengthMaxRun = 200;
    private double heightMax;

    public Cat(String name){
        super(name);
    }
    public void setHeightMax(double heightMax){
        this.heightMax = heightMax;
    }
    private double getHeightMax(){
        return heightMax;
    }
    @Override
    public String run(int length) {
        if (length <= lengthMaxRun)
            return name + " пробежал " + length + " метров!";
        else return "Слишком далеко!";
    }

    @Override
    public String highJump(double height) {
        if (height <= this.getHeightMax())
            return name + " прыгнул вверх на " + height + " метров!";
        return "Слишком высоко!";
    }
}
