package lesson3;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {

    public static HashMap<String, ArrayList<Person>> map = new HashMap<>();
    private ArrayList<Person> list;

    public void setMap(String surname, Person person) {
        if (map.containsKey(surname)) {
            list = map.get(surname);
            list.add(person);
            map.put(surname, list);
        } else {
            list = new ArrayList<>();
            list.add(person);
            map.put(surname, list);
        }
    }

    public static ArrayList<String> getListPhones(String surname) {
        ArrayList<Person> people;
        ArrayList<String> phoneNumbers = new ArrayList<>();
        if (map.containsKey(surname)) {
            people = map.get(surname);
            for (int i = 0; i < people.size(); i++) {
                phoneNumbers.add(people.get(i).getPhone());
            }
        }
        return phoneNumbers;
    }

    public static ArrayList<String> getListEmails(String surname) {
        ArrayList<Person> people;
        ArrayList<String> emailNumbers = new ArrayList<>();
        if (map.containsKey(surname)) {
            people = map.get(surname);
            for (int i = 0; i < people.size(); i++) {
                emailNumbers.add(people.get(i).getEmail());
            }
        }
        return emailNumbers;
    }
}
