package geekbrains.home_work_1.lesson4;

public class Lesson_4 {
    public static void main(String[] args) {
        Worker[] workArr = new Worker[5];
        workArr[0] = new Worker("Суворов Александр Васильевич", "полководец", 123, 500, 69);
        workArr[1] = new Worker("Гагарин Юрий Алексеевич", "космонавт", 456, 700, 34);
        workArr[2] = new Worker("Пушкин Александр Сергеевич", "поэт", 135, 100, 37);
        workArr[3] = new Worker("Достоевский Федор Михайлович", "писатель", 157, 150,59);
        workArr[4] = new Worker("Долгорукий Юрий Владимирович", "князь", 777, 1147, 58);

        //вывод в консоль ФИО и должности на примере одного сотрудника РФ
        System.out.println(workArr[0].namePlusPosition());

        //вывести в консоль данные сотрудников старше 40 лет
        for (int i = 0; i < workArr.length; i++) {
            if (workArr[i].getAge()>40)
                System.out.println(workArr[i].allInformation());
        }

        Worker.setRaiseSalary(workArr);
        //вывести данные сотрудников после повышения з/п лицам страше 45 лет
        for (int i = 0; i < workArr.length; i++) {
            System.out.println(workArr[i].allInformation());
        }
        //вывести id сотрудников РФ
        for (int i = 0; i < workArr.length; i++) {
            System.out.println(workArr[i].namePlusPositionPlusID());
        }
    }
}
