package Password;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(checkPassword("1aGfj5&7"));
        System.out.println(checkPassword("1aGf 5&7"));
        System.out.println(checkPassword("1AGFJ5&7"));
        System.out.println(checkPassword("1agfj5&7"));
        System.out.println(checkPassword("1aGfj5s7"));
        System.out.println(checkPassword("1aGfj5&"));

        enterThePassword();
    }

    private static boolean checkPassword(String password) {
        Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W_])[\\S]{8,}$");
        Matcher m = p.matcher(password);
        return m.matches();
    }

    private static void enterThePassword() {
        String password;

        do {
            System.out.println("Введите пароль!");
            password = scanner.nextLine();

        } while (!checkPassword(password));

        System.out.println("Ваш пароль: " + password);
    }
}
