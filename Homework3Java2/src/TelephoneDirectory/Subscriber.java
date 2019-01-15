package TelephoneDirectory;

public class Subscriber {
    String name;
    String number;

    public Subscriber(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
