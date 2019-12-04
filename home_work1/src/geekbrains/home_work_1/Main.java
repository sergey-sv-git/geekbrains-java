package geekbrains.home_work_1;

public class Main {

    public static void main(String[] args) {
        System.out.println(calculate(2,5,1,3));
        System.out.println(task10and20(2,7));
        isPositiveOrNegative(5);
        System.out.println(greetings("Иван"));
        leapYear(2019);
    }

    public static double calculate(int a, int b, int c, int d){
        return  a * (b + (c*1f)/(d*1f));
    }
    public static boolean task10and20(int x1, int x2) {
        if (((x1 + x2) >= 10)&&((x1 + x2) <= 20)) return true;
        else return false;
    }
    public static void isPositiveOrNegative(int x) {
        if(x >= 0) {
            System.out.println("Введено положительное число: " + x);
        } else {
            System.out.println("Введено отрицательное число: " +x);
        }
    }
    public static String greetings(String name) {
        return "Привет, " + name + "!";
    }
    public static void leapYear(int a){
        int daysOfTheYear;
        if (a%400 == 0) daysOfTheYear = 366;
        else if (a%100 == 0) daysOfTheYear = 365;
        else if (a%4 == 0) daysOfTheYear = 366;
        else daysOfTheYear = 365;
        if (daysOfTheYear == 366) System.out.println(a + " - високосный год.");
        else System.out.println(a + " - невисокосный год.");
    }
}
