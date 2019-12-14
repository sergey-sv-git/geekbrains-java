package geekbrains.home_work_1.lesson4;

public class Worker {
    private String fullName;
    private String position;
    private int phoneNumber;
    private int salary;
    private int age;
    private int id;
    private static int count;

    public Worker(String fullName, String position, int phoneNumber, int salary, int age){
        this.fullName = fullName;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
        id = ++count;
    }

    public String getFullName(){
        return fullName;
    }
    public String getPosition(){
        return position;
    }
    public int getPhoneNumber(){
        return phoneNumber;
    }
    public int getSalary(){
        return salary;
    }
    public int getAge(){
        return age;
    }

    public String namePlusPosition(){
        return getFullName() + " - " + getPosition();
    }

    public String allInformation(){
        return getFullName()+", должность: "+getPosition()+", телефон: "+getPhoneNumber()
                +", зарплата: "+getSalary()+", возраст: "+getAge();
    }

    public static void setRaiseSalary(Worker[] worker){
        for (int i = 0; i < worker.length; i++) {
            if (worker[i].getAge()>45) worker[i].salary+=5000;
        }
    }

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

        setRaiseSalary(workArr);
        //вывести данные сотрудников после повышения з/п лицам страше 45 лет
        for (int i = 0; i < workArr.length; i++) {
            System.out.println(workArr[i].allInformation());
        }
        //вывести id сотрудников РФ
        for (int i = 0; i < workArr.length; i++) {
            System.out.println(workArr[i].id);
        }

    }
}
