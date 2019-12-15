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
    public String namePlusPositionPlusID(){
        return id + ": " + getFullName() + " - " + getPosition();
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
}
