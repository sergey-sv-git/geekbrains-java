package lesson3;

import java.util.*;

public class Main {

    // выбрал TreeSet, чтобы при выводе на печать сортировка была в алфавитом порядке
    public static TreeSet<String> worldList(String[] strArr){
        TreeSet<String> strings = new TreeSet<>();
        for (int i = 0; i < strArr.length; i++) {
            strings.add(strArr[i]);
        }
        return strings;
    }
    public static HashMap<String, Integer> countOfWords(String[] strArr){
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < strArr.length; i++) {
            String word = strArr[i];
            for (int j = 0; j < strArr.length; j++) {
                if (word.equals(strArr[j])) count++;
            }
            map.put(word,count);
            count = 0;
        }
        return map;
    }
    public static void main(String[] args) {
        String[] strArr = {"белеет", "парус", "одинокий", "в", "тумане", "моря", "голубом",
                           "что", "ищет", "он", "в", "стране", "далекой", "что", "кинул", "он", "в", "краю", "родном",
                           "играют", "волны", "ветер", "свищет", "и", "мачта", "гнется", "и", "скрипит",
                           "увы", "он", "счастия", "не", "ищет", "и", "не", "от", "счастия", "бежит"} ;

        Iterator<String> iterator = worldList(strArr).iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        Iterator<Map.Entry<String, Integer>> iterator1 = countOfWords(strArr).entrySet().iterator();
        while (iterator1.hasNext()){
            Map.Entry<String, Integer> map = iterator1.next();
            System.out.println("Слово '" + map.getKey() + "', количество в тексте - " + map.getValue());
        }

        Person person1 = new Person("Иванов", "123", "ivanov@mail.ru");
        Person person2 = new Person("Петров", "234", "petrov@mail.ru");
        Person person3 = new Person("Сидоров", "456", "sidorov@mail.ru");
        Person person4 = new Person("Иванов", "555", "ivanov555@mail.ru");
        Person person5 = new Person("Алексеев", "567", "alekseev@mail.ru");
        Person person6 = new Person("Сидоров", "777", "sidorov777@mail.ru");

        ArrayList<String> phone = PhoneBook.getListPhones("Иванов");
        for (int i = 0; i < phone.size(); i++) {
            System.out.println(phone.get(i));
        }
        ArrayList<String> emails = PhoneBook.getListEmails("Алексеев");
        for (int i = 0; i < emails.size(); i++) {
            System.out.println(emails.get(i));
        }
    }
}
