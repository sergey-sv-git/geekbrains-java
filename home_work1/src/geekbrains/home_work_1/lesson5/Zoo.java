package geekbrains.home_work_1.lesson5;

public class Zoo {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Шарик", 300);// установка ограничения через конструктор
        System.out.println(dog1.swim(550));

        Animal horse = new Horse("Конёк-горбунок");
        ((Horse) horse).setLengthMaxSwim(500); // установка ограничения через set/get
        System.out.println(horse.swim(300));

    }
}
