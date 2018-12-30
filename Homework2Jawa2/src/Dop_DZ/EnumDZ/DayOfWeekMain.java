package Dop_DZ.EnumDZ;

public class DayOfWeekMain {
    public static void main(String[] args) {
        System.out.println(getWorkingHours(DayOfWeek.MONDAY));
        System.out.println(getWorkingHours(DayOfWeek.TUESDAY));
        System.out.println(getWorkingHours(DayOfWeek.WEDNESDAY));
        System.out.println(getWorkingHours(DayOfWeek.THURSDAY));
        System.out.println(getWorkingHours(DayOfWeek.FRIDAY));
        System.out.println(getWorkingHours(DayOfWeek.SATURDAY));
        System.out.println(getWorkingHours(DayOfWeek.SUNDAY));
    }

    static String getWorkingHours(DayOfWeek day) {
        int a = (40 - 8 * day.ordinal());
        if (a > 0) {
            return "До выходных осталось " + a + " рабочих часов";
        } else {
            return "Сегодня выходной день";
        }
    }
}
