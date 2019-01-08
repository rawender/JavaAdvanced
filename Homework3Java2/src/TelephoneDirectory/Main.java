package TelephoneDirectory;

public class Main {
    public static void main(String[] args) {
        TelephoneDirectory phoneDirectory = new TelephoneDirectory();
        phoneDirectory.add("Иванов", "123-45-67");
        phoneDirectory.add("Коровин", "234-56-78");
        phoneDirectory.add("Смирнов", "345-67-89");
        phoneDirectory.add("Петров", "456-78-90");
        phoneDirectory.add("Гуреев", "567-89-01");
        phoneDirectory.add("Ивлев", "678-90-12");
        phoneDirectory.add("Жарко", "789-01-23");
        phoneDirectory.add("Ипатов", "890-12-34");
        phoneDirectory.add("Миронов", "901-23-45");
        phoneDirectory.add("Петров", "012-34-56");

        phoneDirectory.get("Петров");
        phoneDirectory.get("Коровин");
        phoneDirectory.get("Клеменьтьев");
    }
}
