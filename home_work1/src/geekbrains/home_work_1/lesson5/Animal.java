package geekbrains.home_work_1.lesson5;

public abstract class Animal {
    String name;
    public Animal(String name){
        this.name = name;
    }
    public abstract String run(int length);
    public String swim (int length){return null;};//неабстрактный, чтобы не переопределять у птицы и кота
    public abstract String highJump (double height);
}
