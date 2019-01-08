package TelephoneDirectory;

import java.util.ArrayList;

public class TelephoneDirectory {
    ArrayList<Subscriber> td = new ArrayList<>();

    void add(String name, String number) {
        td.add(new Subscriber(name,number));
    }

    void get(String name) {
        int count = 0;
        for (int i = 0; i < td.size(); i++) {
            if (name.equalsIgnoreCase(td.get(i).getName())) {
                count++;
                System.out.println(name + " " + count + ": " + td.get(i).getNumber());
            }
        }
        if (count == 0)
            System.out.println(name + ": В справочнике нет такой фамилии.");
    }
}
